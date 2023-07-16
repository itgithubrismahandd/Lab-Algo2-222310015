//Program sederhana dari Hash Table yang menggunakan metode double hashing//
#include <iostream>
using namespace std;
#define TABLE_SIZE 15
#define PRIME 7
 
class DoubleHash{
    int *hashTable;
    int curr_size;
 
public:
    bool isFull() {  // fungsi untuk memeriksa apakah tabel hash sudah penuh
      return (curr_size == TABLE_SIZE); //fungsi jika hash size mencapai ukuran maksimum
    }
    int hash1(int key){// fungsi untuk menghitung first hash
        return (key % TABLE_SIZE);
    }
 
    int hash2(int key){ //fungsi untuk menghitung second hash
        return (PRIME - (key % PRIME));
    }
 
    DoubleHash() {
        hashTable = new int[TABLE_SIZE];
        curr_size = 0;
        for (int i=0; i<TABLE_SIZE; i++)
            hashTable[i] = -1;
    }
 
    void insertHash(int key){ // fungsi untuk memasukkan kunci ke dalam tabel hash
        if (isFull())
            return;
        int index = hash1(key);
 
        if (hashTable[index] != -1){ //kondisi jika terjadi collision
            int index2 = hash2(key); // dapatkan index2 dari second hash
            int i = 1;
            while (1){
                int newIndex = (index + i * index2) %
                                        TABLE_SIZE;

                if (hashTable[newIndex] == -1){
                    hashTable[newIndex] = key;
                    break;
                }
                i++;
            }
        }

        else // kondisi jia tidak terjadi collision
            hashTable[index] = key;
        curr_size++;
    }
 
    void displayHash() //fungsi untuk mendisplay hash table
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            if (hashTable[i] != -1)
                cout << i << " --> "
                     << hashTable[i] << endl;
            else
                cout << i << endl;
        }
    }
};

int main()
{
    int a[] = {11, 55, 27, 7, 36, 10, 64, 87, 5, 42, 15, 30};
    int n = sizeof(a)/sizeof(a[0]);
 
    // memasukkan keys kedalam hash table
    DoubleHash h;
    for (int i = 0; i < n; i++)
        h.insertHash(a[i]);
 
    //menampilkan hash table
    h.displayHash();
    return 0;
}