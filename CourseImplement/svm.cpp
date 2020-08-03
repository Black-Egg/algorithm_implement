#include <iostream>
#include <string>
#include <vector>
using namespace std;

string remove_plus(string s){
    string a = s.substr(0,1);
    if(a == "+")
        s = s.substr(1,s.length()-1);
    return s;
}

string check(int vec, int index){
    string var[] = {"u","v","w","x","y",""};
    if(vec == 0)
        return "";
    else{
        if(index == 0){
            if(vec == 1){
                return var[index];
            }
            if(vec == -1){
                return "-"+var[index];
            }
            else{
                return to_string(vec)+var[index];
            }
        }
        else{
            if(vec == 1){
                return "+"+var[index];
            }
            if(vec < 0){
                return to_string(vec)+var[index];
            }
            else{
                return "+"+to_string(vec)+var[index];
            }
        }

    }
}

int main(){
    int t,tmp;
    cin >> t;
    while(t){
        int func_2d[6];
        string out = "";
        for(int i=0; i<6; i++){
            cin>>tmp;
            func_2d[i] = tmp;
        }

        for(int i=0; i<6; i++){
            //cout << func_2d[i];
            out = out + check(func_2d[i],i);
        }
        cout << remove_plus(out) << endl;
        t--;
    }
}
