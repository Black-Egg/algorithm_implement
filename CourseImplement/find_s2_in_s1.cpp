#include <iostream>
#include <string.h>
using namespace std;

int search(char s1[], char s2[]){
    int i=0;
    int j;
    int len2 = strlen(s2);
    while(s1[i]){
        for(j=0; j<len2; j++){
            if(s1[i+j] != s2[j]){
                break;
            }
        }
        if(j>=len2)
            return i;
        i++;
    }
    return -1;
}

int main(){
    char s1[100];
    char s2[100];
    int result;
    while(cin>>s1>>s2){
        result = search(s1,s2);
        cout<<result<<endl;
    }
    return 0;
}
