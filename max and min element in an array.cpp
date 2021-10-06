#include<bits/stdc++.h>
using namespace std;
int compare(int arr[],int n,int min,int max){
    if(n==1){
            arr[0]=min;
            arr[0]=max;


    }
    else{
        arr[0]=min;
        arr[0]=max;
        for(int i=1;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
    }


}


int main(){
    int t;
    cin>>t;
    while(t--){
        int n;
        cin>>n;
        int arr[n];
        for(int i=0;i<n;i++){
            cin>>arr[i];
        }
        int max,min;
        compare(arr,n,min,max);
        cout<<min<<" "<<max<<endl; 


    }
    return 0;
 }
