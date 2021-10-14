#include<iostream>
using namespace std;
const int MAX_SIZE_OF_SEQUENCE = 20;
const int MIN_SIZE_OF_SEQUENCE = 2;
int sum(int *sequance, int size);
int mean(int *sequance, int size);
int amountOfPositiveElements(int *sequence, int size);
int calculateElementsBiggerThanMean(int *sequence,int size);
void outputConsole(int number);
void whatAmIDoing();
void sequenceOut(int *sequence, int size);
int checkInput(int bigBoarder, int smallBoarder);
int *inputSequence(int size);
int inputSizeOfSequence();
int main()
{
    whatAmIDoing();
    int sizeOfSequence = inputSizeOfSequence();
    int *sequence = inputSequence(sizeOfSequence);
    sequenceOut(sequence, sizeOfSequence);
    int amountOfElementsBiggerThanMean = calculateElementsBiggerThanMean(sequence, sizeOfSequence);
    outputConsole(amountOfElementsBiggerThanMean);
    return 0;
}

void whatAmIDoing(){
    cout << "You input size and elements of sequence.\n";
    cout << "This program calculates number of elements.\n";
    cout << "That bigger than mean of positive elements you input.\n";
}

int checkInput(int bigBoarder, int smallBoarder){
    bool isIncorrect;
    int input;
    do{
        isIncorrect = false;
        cin >> input;
        if (cin.fail()){
            isIncorrect = true;
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(),'\n');
            cout << "Your input is wrong. Input number, please.\n";
        }
        if((!isIncorrect) && (input < smallBoarder)){
            isIncorrect = true;
            cout << "Your number is too small. Input bigger one(bigger than " << smallBoarder << ").\n";
        }
        if((!isIncorrect) && (input > bigBoarder)){
                isIncorrect = true;
            cout << "Your number is too big. Input smaller one(smaller than " << bigBoarder << ").\n";
            }
    } while(isIncorrect);
    return input;
}

int inputSizeOfSequence(){
    cout << "Input size of sequence.\n";
    int size = checkInput(MAX_SIZE_OF_SEQUENCE, MIN_SIZE_OF_SEQUENCE);
    return size;
}

int *inputSequence(int size){
    cout << "Input elements of sequence.\n";
    int *sequence = new int[size];
    for (int i = 0; i < size; i++)
        sequence[i] = checkInput(INT16_MAX, INT16_MIN);
    return sequence;
}

int sum (int *sequence,int size){
    int sum = 0;
    for(int i = 0; i < size; i++)
        if (sequence[i] > 0)
            sum = sum + sequence[i];
    return sum;
}

int amountOfPositiveElements(int *sequence, int size){
    int amount = 0;
    for(int i = 0; i < size; i++)
        if (sequence[i] > 0)
            amount++;
    if (amount == 0)
        amount = 1;
    return amount;
}

int mean(int *sequence, int size){
    return sum(sequence, size)/amountOfPositiveElements(sequence,size);
}

int calculateElementsBiggerThanMean(int *sequence,int size){
    int average = 0;
    for(int i = 0; i < size; i++)
        if (sequence[i] > mean(sequence, size))
            average++;
    return average;
}

void outputConsole(int number){
    cout << "Amount of numbers bigger than mean of positive elements of sequence is ";
    cout << number << ".\n";
}

void sequenceOut(int *sequence, int size){
    cout << "Your number is\n";
    for(int i = 0; i < size; i++)
        cout << sequence[i] << endl;
}
