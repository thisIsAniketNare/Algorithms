//Made by Aniket on 22/08/16
//program for converting infix to prefix by following steps
//1. manipulating input string in reverse order
//2. postfixing
//3. reversing the result obtained from 2.

#include<stdio.h>
#include<conio.h>
#include<string.h>

int main(void){
  int i,j,k,p,q;
  char op[10];
  char expression[10],res[10];

  printf("Enter expression\n");
  scanf("%s",&expression);

  j=0;
  k=0;
  p=0;

  for(i=strlen(expression)-1;i>=0;i--){
    if(expression[i]<123&&expression[i]>=97){
      printf("%c",expression[i]);
      res[p]=expression[i];p++;
    }
    else if(expression[i]=='+'||expression[i]=='-'||expression[i]=='*'||expression[i]=='/'){
      op[j]=expression[i];

      if(op[j-1]=='/'&&op[j]=='*'){
	printf("%c",op[j-1]);
	res[p]=op[j-1];p++;
	op[j-1]=op[j];
	j--;
      }
      else if((op[j-1]=='/')&&(op[j]=='+'||op[j]=='-')){
	printf("%c",op[j-1]);
	res[p]=op[j-1];p++;
	op[j-1]=op[j];
	j--;
      }
      else if((op[j-1]=='*')&&(op[j]=='+'||op[j]=='-')){
	printf("%c",op[j-1]);
	res[p]=op[j-1];p++;
	op[j-1]=op[j];
	j--;
      }
      j++;
    }
  }

  for(k=j-1;k>=0;k--){
    printf("%c",op[k]);
    res[p]=op[k];
    p++;
  }

  printf("\n");

  for(q=p-1;q>=0;q--){
    printf("%c",res[q]);
  }

  getch();
  clrscr();
  return 0;
}
