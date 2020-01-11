#include<iostream>

using namespace std;

int fact(int x){
    int ans=1;
    for(int i=1;i<=x;i++){
        ans=ans*i;
    }
    return ans;
}
void displayFact(int n,int r){
    int nfact=fact(n);
    int rfact=fact(r);
    int nmrfact=fact(n-r);

    cout<<(nfact/(nmrfact*rfact))<<endl;
}


int binToDeci(int n){
    int ans=0;
    int pow=1;
    while(n!=0){
        int rem=n%10;
        n/=10;
       ans=ans+ rem*pow;
        pow=pow*2;
    }
    return ans;
}

int octalToDeci(int n){
    int ans=0;
    int pow=1;
    while(n!=0){
        int rem=n%10;
        n/=10;
       ans=ans+ rem*pow;
        pow=pow*8;
    }
    return ans;
}

int anyBaseToDecial(int n,int sb){
    int ans=0;
    int pow=1;
    while(n!=0){
        int rem=n%10;
        n/=10;
        ans=ans+rem*pow;
        pow=pow*sb;
    }
    return ans;
}

 int deciToAnyBase(int n,int db){
        int ans=0;
        int pow=1;
        while(n!=0){
            int rem=n%db;
            n=n/db;
            ans=rem*pow+ans;
            pow=pow*10;
        }
        return ans;
    }

int anyBaseToAnyBase(int n,int sb,int db){
    int ans=anyBaseToDecial(n,sb);
    int finalans=deciToAnyBase(ans,db);
    return finalans;
}

int octalAdd(int n1,int n2){
    int ans=0;
    int pow=1;
    int carry=0;
    while(n1 != 0 || n2 != 0 || carry!=0){
        int r1=n1 % 10; n1/=10;
        int r2=n2 % 10; n2/=10;
        int rem = r1+ r2+ carry;
        carry = rem / 8;
        rem = rem % 8;
        ans = ans + rem * pow;
        pow = pow * 10; 
    }
    return ans;    

}


int main(){
    cout<< octalAdd(77,1234567) <<endl;
    // int n=10;
    // int r=5;

    // int nfact=fact(n);
    // int rfact=fact(r);
    // int nmrfact=fact(n-r);

    // cout<<(nfact/(rfact*nmrfact))<<endl;
    //  displayFact(n,r);
    return 0;
}