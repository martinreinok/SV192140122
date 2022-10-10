#include <stdio.h>
#include <stdlib.h>
#include <civlc.cvh>
$input int n = 4; // size of input array
$input int inorder[n+1]; // input array from which the tree is derived

struct Node {
	int data;
	struct Node *left, *right;
};

struct Node* newNode(int key) {
	struct Node* node = (struct Node*) malloc(sizeof(struct Node));
	node->data = key;
	node->left = node->right = 0;
	return node;
}

void deleteTree(struct Node* node) {
  if (node == 0) {
    return;
  }
  deleteTree(node->left);
  deleteTree(node->right);
  free(node);
}

void inorderTraversal(struct Node* root) {
	if (root == 0) {
		return;
	}
	inorderTraversal(root->left);
	fprintf(stdout, "%i ", root->data);
	inorderTraversal(root->right);
}

int minElementIndex(int inorder[], int start, int end) {
	int minIndex = start;
	for (int i = start + 1; i <= end; i++) {
		if(inorder[minIndex] > inorder[i]) {
			minIndex = i;
		}
	}
	return minIndex;
}

struct Node* constructTree(int inorder[], int start, int end) {
	if (start > end) {
		return 0;
	}
	
	int index = minElementIndex(inorder, start, end);
	struct Node *root = newNode(inorder[index]);
	root->left = constructTree(inorder, start, index-1);
	root->right = constructTree(inorder, index+1, end);
	return root;
}

void printTree(struct Node* root) {
	if (root != 0) {
		fprintf(stdout, "Data: %d\n", root->data);
		printf("Left tree: \n");
		printTree(root->left);
		printf("Right tree: \n");
		printTree(root->right);
	}
}

int main() {
	struct Node* root;
	root = constructTree(inorder, 0, n);
	printTree(root);
  deleteTree(root);
	return 0;
}
