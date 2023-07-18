#include<iostream>
#include<stdio.h>
using namespace std;
#define INFINITY 9999
#define max 6
//#Risma Handayani (222310015)
void dijkstra(int G[max][max],int n,int startnode) {
   int cost[max][max],distance[max],pred[max];
   int visited[max],count,mindistance,nextnode,i,j;
   for(i=0;i<n;i++)
      for(j=0;j<n;j++)
   if(G[i][j]==0)
      cost[i][j]=INFINITY;
   else
      cost[i][j]=G[i][j];
   for(i=0;i<n;i++) {
      distance[i]=cost[startnode][i];
      pred[i]=startnode;
      visited[i]=0;
   }
   distance[startnode]=0;
   visited[startnode]=1;
   count=1;
   while(count<n-1) {
      mindistance=INFINITY;
      for(i=0;i<n;i++)
         if(distance[i]<mindistance&&!visited[i]) {
         mindistance=distance[i];
         nextnode=i;
      }
      visited[nextnode]=1;
      for(i=0;i<n;i++)
         if(!visited[i])
      if(mindistance+cost[nextnode][i]<distance[i]) {
         distance[i]=mindistance+cost[nextnode][i];
         pred[i]=nextnode;
      }
      count++;
   }
   for(i=0;i<n;i++)
   if(i!=startnode) {
      cout<<"\nDerajat dari Node "<<i<<" = "<<distance[i];
      cout<<"\nLintasan = "<<i;
      j=i;
      do {
         j=pred[j];
         cout<<"<-"<<j;
      }while(j!=startnode);
   }
}

int main() {
   int G[max][max]={{0,7,9,0,0,14},{7,0,10,15,0,0},{9,10,0,11,0,2},{0,15,11,0,6,0},{0,0,0,6,0,9},{14,0,2,0,9,0}};
   int n=6;
   int u=0;
  
   dijkstra(G,n,u);
  
   return 0;
}
