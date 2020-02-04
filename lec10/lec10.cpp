#include<iostream>
#include<vector>
using namespace std;

void display(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        cout<<arr[i]<<" ";
    }
    cout<<endl;
}

void fn(vector<int>& arr){
    for(int i=0;i<arr.size();i++){
        arr[i] = arr[i] +20;
    }
    display(arr);
}

int binarySearch(vector<int>& arr,int data){
        int left=0;
        int right=arr.size()-1;
        while(left<=right){
            int mid=(left+right)/2;
            if(arr[mid] == data){
                return mid;
            }else if(arr[mid]<data){
                left=mid+1;
            }else{
                right = mid -1;
            }        }
        return -1;
    }


int lastOcc(vector<int>& arr,int data){
        int left = 0;
        int right = arr.size()-1;
        while(left<=right){
            int mid = (left+right)/2;
            if(arr[mid] == data){
                if(mid+1 < arr.size() && arr[mid+1] == data){
                    left = mid+1;               
                 }else{
                       return mid;
                 }
            }else if(arr[mid]>data){
                    right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

vector<int> ceilAndFloor(vector<int>& arr,int data ){
    vector<int> ans{-1,-1};
    int left = 0 ;
    int right = arr.size() - 1;
    while(left<=right){
        int mid = (left+right) / 2;
        if(data==arr[mid]){
            ans[0] = data;
            ans[1] = data;
            return ans;
        }else if(data<arr[mid]){
            right = mid -1;
        }else{
            left = mid + 1;
        }
    }
    if(left == arr.size()){
        ans[0] = arr[right];
    }else if(right == -1){
        ans[1] = arr[left];
    }else{
        ans[0] = arr[right];
        ans[1] = arr[left];
    }
    return ans;
}


int main(){
    int rows=0;int cols=0;
    // vector<vector<int> > arr(rows,vector(cols,0));
    // vector<vector<int> > arr{{123,23},{124,34}}; 
    vector<int> arr{3,5,18,20,25,35,38};
    // fn(arr);
    vector<int> ans = ceilAndFloor(arr,21);
    display(ans);
    return 0;
    
}