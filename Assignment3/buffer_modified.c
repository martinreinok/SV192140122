/*
 * Modified from:
 * Copyright (c) 2020 Siddharth Chandrasekaran <siddharth@embedjournal.com>
 *
 * SPDX-License-Identifier: Apache-2.0
 */

int* buffer;
int head = 0;
int tail = 0;
int const maxlen = 4;

/*@
requires maxlen >= 0 && \valid(buffer+(0..maxlen-1));
requires \valid(output_arr);
requires 0 <= tail < maxlen;
requires 0 <= head < maxlen;
assigns tail, *output_arr;

behavior good:
	assumes head != tail && tail + 1 < maxlen;
	ensures tail == \old(tail) + 1;
	ensures *output_arr == buffer[\old(tail)];
	ensures \result == 0;
	

behavior bad:
	assumes head == tail;
	ensures \result == -1;

behavior reset_buffer:
	assumes tail != head && tail + 1 >= maxlen;
	ensures tail + 1 == maxlen ==> tail == 0;
	ensures *output_arr == buffer[\old(tail)];
	ensures \result == 0;
	

complete behaviors;
disjoint behaviors;
*/
int pop(int *output_arr) {
	int next;
	if (head == tail)
		return -1; // buffer is empty
	next = tail + 1;
	if (next >= maxlen)
		next = 0;
	*output_arr = buffer[tail];
	tail = next;

   	// Exercise IV
	// assert \forall integer i; 2 <= i < head && maxlen > 0 ==> buffer[head] == buffer[head-1] + buffer[head-2];

	return 0;
}

/*@ // Exercise I
requires maxlen >= 0 && \valid(buffer+(0..maxlen-1));
requires 0 <= tail < maxlen;
requires 0 <= head < maxlen;
assigns head, buffer[0..head];

behavior good:
	assumes head + 1 < maxlen && head + 1 != tail;
	ensures 0 <= head + 1 < maxlen ==> head == \old(head) + 1;
	ensures buffer[\old(head)] == data;
	ensures \result == 0;

behavior reset_buffer:
	assumes head + 1 >= maxlen && tail != 0;
	ensures head + 1 >= maxlen ==> head == 0;
	ensures buffer[\old(head)] == data;
	ensures \result == 0;

behavior bad:
	assumes (head + 1 < maxlen && head + 1 == tail) || (head + 1 >= maxlen && 0 == tail);
	ensures \result == -1;

complete behaviors;
disjoint behaviors good, bad;
*/
int push(int data) {
	int next;
	next = head + 1;
	if (next >= maxlen)
		next = 0;
	if (next == tail)
		return -1; // buffer is full
	buffer[head] = data;
	head = next;
	// Exercise IV
	// assert \forall integer i; 2 <= i <= head && maxlen > 2 ==> buffer[head] == buffer[head-1] + buffer[head-2];

	return 0;
}

/*
WP will not attempt to prove the preconditions of the main function, 
since it cannot make any assumption about its calling context.
https://stackoverflow.com/questions/66867596/frama-c-wp-and-preconditions
*/

/*@
assigns head, tail, buffer;
*/
int main() {
	int data[4];
	buffer = data;
	int out[4];
	int a = 1;
	int b = 1;
	//@ assert head == 0;
	push(a);
	//@ assert head == (maxlen > 2) ? 1 : 0;
	push(b);

	/*@
	loop invariant 2 <= i <= maxlen-1;	// Invariant holds during loop execution and after the execution.
	loop invariant ((b == b + a) && (a == b));
	loop assigns i, a, b; 
	loop variant maxlen - 1 - i; 			// Variant proves the termination of the loop          
	*/
	for (int i = 2; i < maxlen-1; i++) {
		int sum = a + b;
		if(push(sum)) {
			// Out of space
			return -1;
		}
		a = b;
		b = sum;
	}

	/*@
	loop invariant 0 <= j <= maxlen-1;
	loop assigns j, out[0 .. maxlen-1]; 
	loop variant  maxlen -1 - j;
	*/
	for (int j = 0; j < maxlen-1; j++) {
		if (pop(&out[j])) {
			// Buffer is empty
			return -1;
		}
	}
	return 0;
}
