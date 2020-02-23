#include<iostream>
#include<vector>
using namespace std;

void printPre(vector<int> &arr,int i)
{   if(i==arr.size()){
    return;
    }
    cout<<arr[i]<<endl;
    printPre(arr,i+1);
}

int foc(vector<int> &arr,int data,int idx){


    int recAns = foc(arr,data,idx+1);
    if(arr[idx] == data){
        recAns = idx;
    }

    return recAns;
}


int loPre(vector<int> &arr,int idx,int data,int loc){
    if(idx==arr.size()){
        return loc;
    }
    if(arr[idx] == data){
        loc = idx;
    }
    int recAns =  loPre(arr,idx+1,data,loc);
    return recAns;
}
vector<int> allocc(vector<int> &arr,int i,int data,int count){
    if(i==arr.size()){
        vector<int> baseAns(count,0);
        
        return baseAns;
    }
    if(arr[i]== data){
        count++;
    }
    vector<int> recAns = allocc(arr,i+1,data,count);
    if(arr[i]== data){
        recAns[count-1] = i;
    }
    return recAns;
}



void subseq(string ques,string ans){
    if(ques.size()==0){
        cout<<ans<<endl;
        return;
    }

    char ch = ques[0];

    string roq = ques.substr(1);

    subseq(roq,ans+ch);
    subseq(roq,ans);
}



vector<string> subseq1(string ques){
    if(ques.size() == 0){
        vector<string> base;
        base.push_back("");
        return base;
    }
    char ch = ques[0];
    string roq = ques.substr(1);
    vector<string> recAns = subseq1(roq);
    vector<string> myans;
    for(int i=0;i<recAns.size();i++){
        myans.push_back(ch + recAns[i]);
    }
    for(int i=0;i<recAns.size();i++){
        myans.push_back(recAns[i]);
    }
    return myans;
}
vector<string> floodfill(vector<vector<int>> &arr,int i,int j){
    if(i==arr.size()-1 && j == arr[0].size()-1){
        vector<string> base;
        base.push_back("");
        return base;
    }
    arr[i][j] =1;
    vector<string> myans;
    // up
    if(i-1>=0 && arr[i-1][j] == 0){
        vector<string> recans = floodfill(arr,i-1,j);
        for(int i=0;i<recans.size();i++){
            myans.push_back("u"+recans[i]);
        }
    }
    // left
    if(j-1>=0 && arr[i][j-1] == 0 ){
        vector<string> recans = floodfill(arr,i,j-1);
        for(int i=0;i<recans.size();i++){
            myans.push_back("l"+recans[i]);
        }
    }
    // down 
    if( i+1 <arr.size() && arr[i+1][j] == 0){
        vector<string> recans = floodfill(arr,i+1,j);
        for(int i=0;i<recans.size();i++){
            myans.push_back("d"+recans[i]);
        }
    }
    // right
    if(j+1 < arr[0].size() && arr[i][j+1] == 0){
        vector<string> recans = floodfill(arr,i,j+1);
        for(int i=0;i<recans.size();i++){
            myans.push_back("r"+recans[i]);
        }
    }
    arr[i][j] = 0;
    return myans;
}



int main(){
    vector<vector<int>> arr{
        {0,0,0,0,0},
        {0,0,1,0,0},
        {0,0,0,1,0},
        {0,0,0,0,0},
        {0,1,0,0,0}};
    
vector<string> ans = floodfill(arr,0,0);
     
    // vector<int> arr{10,20,30,40};

    // printPre(arr,0);
    // subseq("abc","");
    
    // vector<string> ans =subseq1("abc");

    for(int i=0;i<ans.size();i++)
        {cout<<ans[i]<<endl;}
    cout<<ans.size();
    return 0;
}