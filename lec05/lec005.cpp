#include<iostream>
#include<vector>

using namespace std;
void input(vector<int>& arr){
    for(int i=0;i<arr.size();i++){ cin>>arr[i]; }
}
void display(vector<int>& arr){   
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}


int findMin(vector<int>& arr){
    int mymin=arr[0];
    for(int i=1;i<arr.size();i++){
        if(arr[i]<mymin){
            mymin = arr[i];
        }
    }
return mymin;
}

bool findInArr(vector<int>& arr,int data ){
    // bool isthere = false;
    for(int i=0;i<arr.size();i++){
        if(arr[i]==data){
            return true;
        }
    }
    return false;
}

int main(){
    bool isthre=true;
    int size=0;
    cout<<"enter size of array"<<endl;
    cin>>size;
    vector<int> arr(size,0);
    cout<<"enter elements"<<endl;
    input(arr);
    cout<<findMin(arr)<<endl;
    return 0;
}



