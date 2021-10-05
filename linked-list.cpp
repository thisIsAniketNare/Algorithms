//Made by Aniket on 2/8/2016
//The following code is the application of Linked List,
//with functions to add elements to anywhere in Linked List,
//to remove elements from anywhere inside the Linked List,
//number of elements of Linked List, and to display the list.

#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#define NULL 0

void init();
void add();
void add_start();
void add_end();
void add_between();
void remove();
void remove_start();
void remove_end();
void remove_between();
int size();


struct list{
  int data;
  struct list *next;
}*start,*ptr,*node;


//Initialization
void init(){
  int num;
  start=(struct list*)malloc(sizeof(struct list));
  printf("Enter element\n");
  scanf("%d",&num);
  start->data=num;
  start->next=NULL;
  ptr=start;
}


//Inserting elements
void add(){
  int key;
  printf("Press 1 to add at start  ");
  printf("Press 2 to add at back  ");
  printf("Press 3 to add in between\n");
  scanf("%d",&key);

  switch(key){
    case 1:
      add_start();
      break;
    case 2:
      add_end();
      break;
    case 3:
      add_between();
      break;
  }
}

void add_start(){
      int num;
      node=(struct list*)malloc(sizeof(struct list));
      printf("Enter element\n");
      scanf("%d",&num);
      node->data=num;
      node->next=start;
      start=node;
}

void add_end(){
      int num;
      node=(struct list*)malloc(sizeof(struct list));
      ptr->next=node;
      printf("Enter element\n");
      scanf("%d",&num);
      node->data=num;
      node->next=NULL;
      ptr=node;
}

void add_between(){
      int num1,num2,input,bool,element,position,j;
      printf("Press 1 to add by value  ");
      printf("  Press 2 to add by position\n");
      scanf("%d",&input);
      switch(input){
	case 1:
	  ptr=start;
	  printf("Enter element ""after"" which u want to insert\n");
	  scanf("%d",&element);
	  bool=1;
	  while(bool==1){
	    if(ptr->data==element){
	      printf("Enter element\n");
	      scanf("%d",&num1);
	      node=(struct list*)malloc(sizeof(struct list));
	      node->data=num1;
	      node->next=ptr->next;
	      ptr->next=node;
	      break;
	    }
	    else{
	      ptr=ptr->next;
	      bool=1;
	    }
	  }
	  while(ptr->next!=NULL){
	    ptr=ptr->next;
	  }
       break;
       case 2:
	 ptr=start;
	 printf("Enter position ""after"" which u want to insert\n");
	 scanf("%d",&position);
	 j=1;
	 while(j<position){
	   ptr=ptr->next;
	   j++;
	 }
	 printf("Enter element\n");
	 scanf("%d",&num2);
	 node=(struct list*)malloc(sizeof(struct list));
	 node->data=num2;
	 node->next=ptr->next;
	 ptr->next=node;
	 while(ptr->next!=NULL){
	   ptr=ptr->next;
	 }
       break;
      }
}


//Removing elements
void remove(){
  int key,position,element;
  struct list *pre;
  printf("Enter 1->start  2->end  3->in between\n");
  scanf("%d",&key);
  switch(key){
  case 1:
    remove_start();
  break;
  case 2:
    remove_end();
  break;
  case 3:
    remove_between();
  break;
  }
}

void remove_start(){
    ptr=start;
    ptr=ptr->next;
    free(start);
    start=ptr;
}

void remove_end(){
    struct list *pre;
    ptr=start;
    while(ptr->next!=NULL){
      pre=ptr;
      ptr=ptr->next;
    }
    pre->next=NULL;
    free(ptr);
}

void remove_between(){
    int input,element,position,j;
    struct list *pre;
    printf("Press 1-> By value   2->By position\n");
    scanf("%d",&input);
    switch(input){
    case 1:
    printf("Enter element\n");
    scanf("%d",&element);
    ptr=start;
    pre=start;
    while(pre->data!=element){
      ptr=pre;
      pre=pre->next;
    }
    ptr->next=pre->next;
    free(pre);
    while(ptr->next!=NULL){
	   ptr=ptr->next;
	 }
    break;
    case 2:
    printf("Enter position\n");
    scanf("%d",&position);
    ptr=start;
    pre=start;
    j=1;
    while(j<position){
      ptr=pre;
      pre=pre->next;
      j++;
    }
    ptr->next=pre->next;
    free(pre);
    while(ptr->next!=NULL){
	   ptr=ptr->next;
	 }
    break;
    }
}
//sorting list
void sort(){
  int k,p,q,r;
  p=size();
  for(q=1;q<=p-1;q++){
    ptr=start;
      for(r=1;r<=p-1;r++){
	if((ptr->data)>(ptr->next->data)){
	  k=ptr->data;
	  ptr->data=ptr->next->data;
	  ptr->next->data=k;
	}
	ptr=ptr->next;
      }
  }
}

//Counting existing elements in list.
int size(){
  int count;
  ptr=start;
  count=0;
  while(ptr!=NULL){
    ptr=ptr->next;
    count++;
  }
  return count;
}


//Main function
int main(void){
  int key,bool,count;
  bool=1;
  init();
  while(bool==1){
    printf("Enter 1->add  2->to remove  3->sort  0 ->exit\n");
    scanf("%d",&key);
    if(key==1){
      add();
      bool=1;
    }
    else if(key==2){
      remove();
      bool=1;
    }
    else if(key==3){
      sort();
    }
    else if(key==0){
      break;
    }
  }
  ptr=start;
  while(ptr!=NULL){
    printf("%d-->",ptr->data);
    ptr=ptr->next;
  }
  count=size();
  printf("\nSize: %d\n",count);
  getch();
  clrscr();
  return 0;
}
