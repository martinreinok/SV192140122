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
/*
 * Modified from:
 * Copyright (c) 2020 Siddharth Chandrasekaran <siddharth@embedjournal.com>
 *
 * SPDX-License-Identifier: Apache-2.0
 */
#include <limits.h>

int* buffer;
int head = 0;
int tail = 0;
int const maxlen = 4;


int pop(int *output_arr) {
	int next;

	if (head == tail)
		return -1; // buffer is empty

	next = tail + 1;
	if (next >= maxlen)
		next = 0;

	*output_arr = buffer[tail];
	tail = next;
	return 0;
}

/*@
requires INT_MIN <= data <= INT_MAX;
requires INT_MAX < maxlen && maxlen > INT_MIN;
requires \valid(buffer + (0 .. maxlen-1));
requires 0 <= head < maxlen;
assigns head, buffer[head];
ensures (head + 1 >= maxlen) ==> (head == 0) && (head + 1 < maxlen) ==> (head == \old(head) + 1);
*/

/*
PUSH:
if head + 1 >= maxlen : head = 0
if head + 1 < maxlen : head ++
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
	//@ assert 0 <= head && head + 1 <= maxlen;
	return 0;

}



int main() {
	int data[4];
	buffer = data;
	int out[4];
	int a = 1;
	int b = 1;
	push(a);
	push(b);
	for (int i = 2; i < maxlen-1; i++) {
		int sum = a + b;
		if(push(sum)) {
			// Out of space
			return -1;
		}
		a = b;
		b = sum;
	}

	for (int j = 0; j < maxlen-1; j++) {
		if (pop(&out[j])) {
			// Buffer is empty
			return -1;
		}
	}
	return 0;
}


int pop(int *output_arr) {
	int next;

	if (head == tail)
		return -1; // buffer is empty

	next = tail + 1;
	if (next >= maxlen)
		next = 0;

	*output_arr = buffer[tail];
	tail = next;
	return 0;
}

/*@ 
  
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
	return 0;
}


int main() {
	int data[4];
	buffer = data;
	int out[4];

	int a = 1;
	int b = 1;
	push(a);
	push(b);
	for (int i = 2; i < maxlen-1; i++) {
		int sum = a + b;
		if(push(sum)) {
			// Out of space
			return -1;
		}
		a = b;
		b = sum;
	}

	for (int j = 0; j < maxlen-1; j++) {
		if (pop(&out[j])) {
			// Buffer is empty
			return -1;
		}
	}
	return 0;
}
