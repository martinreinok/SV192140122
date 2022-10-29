/*

 * Modified from:

 * Copyright (c) 2020 Siddharth Chandrasekaran <siddharth@embedjournal.com>

 *
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
requires \valid(output_arr) ;
assigns tail, *output_arr;
behavior normal:
	assumes head != tail;
	ensures (tail + 1 >= maxlen) ==> (tail == 0) 
		&& (tail + 1 < maxlen) ==> (tail == \old(tail) + 1) 
		&& \result == (0)
		&& *output_arr == buffer[tail];

behavior error:
	assumes head == tail;
	ensures \result == (-1);
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
	return 0;
}
/*@
//requires \valid(buffer + (0 .. maxlen)) ;
//requires (0 <= head <= maxlen);
requires head >= 0;
assigns head, buffer[head];
behavior normal:
	assumes head + 1 != tail;
	ensures (head + 1 >= maxlen) ==> (head == 0) 
		&& (head + 1 < maxlen) ==> (head == \old(head) + 1) 
		&& \result == (0)
		&& buffer[head] == data;

behavior error:
	assumes head  == tail - 1;
	ensures \result == (-1);
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
	/*@
	assigns a,b;
	behavior normal:
		//assumes !push(a + b);
		// ensures a == b 
		// 	&& b == a + \old(b);
	behavior error:
		//assumes push(a + b);
		// ensures \result == (-1);
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

	for (int j = 0; j < maxlen-1; j++) {
		if (pop(&out[j])) {
			// Buffer is empty
			return -1;
		}
	}
	return 0;
}

 * SPDX-License-Identifier: Apache-2.0

 */



int* buffer;

int head = 0;

int tail = 0;

int const maxlen = 4;





/*@

requires \valid(output_arr) ;



assigns tail, *output_arr;



behavior normal:

	assumes head != tail;

	ensures (tail + 1 >= maxlen) ==> (tail == 0) 

		&& (tail + 1 < maxlen) ==> (tail == \old(tail) + 1) 

		&& \result == (0)

		&& *output_arr == buffer[tail];



behavior error:

	assumes head == tail;

	ensures \result == (-1);

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

	return 0;

}



/*@

//requires \valid(buffer + (0 .. maxlen)) ;

//requires (0 <= head <= maxlen);



requires head >= 0;

assigns head, buffer[head];



behavior normal:

	assumes head + 1 != tail;

	ensures (head + 1 >= maxlen) ==> (head == 0) 

		&& (head + 1 < maxlen) ==> (head == \old(head) + 1) 

		&& \result == (0)

		&& buffer[head] == data;



behavior error:

	assumes head  == tail - 1;

	ensures \result == (-1);

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



	/*@

	assigns a,b;

	behavior normal:

		//assumes !push(a + b);

		// ensures a == b 

		// 	&& b == a + \old(b);

	behavior error:

		//assumes push(a + b);

		// ensures \result == (-1);

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



	for (int j = 0; j < maxlen-1; j++) {

		if (pop(&out[j])) {

			// Buffer is empty

			return -1;

		}

	}



	return 0;

}
