#ifndef QUEUE_H 
#define QUEUE_H 
#include <iostream> 
#include <cstdlib> 
#include <stdexcept>

using namespace std; 

template <typename T> 
class Node 
{
    public:
        Node();
        Node(T data);
        T getData() const;
        Node<T> *getNext() const;
        bool setData(T data);
        bool setNext(Node<T> *next); 

    private:
        T data;
        Node<T> *next;
}; 

template <typename T> 
Node<T>::Node()
{
    this->next = NULL; 
}

template <typename T> 
Node<T>::Node(T data)
{
    this->data = data;
    this->next = NULL; 
}

template <typename T> 
T Node<T>::getData() const 
{
    return this->data; 
}

template <typename T> 
Node<T> *Node<T>::getNext() const 
{
    return this->next;  
}

template <typename T> 
bool Node<T>::setData(T data)
{
    this->data = data;
    return true; 
}

template <typename T> 
bool Node<T>::setNext(Node<T> *next)
{
    this->next = next;
    return true; 
}

template <typename T> 
class Queue 
{
    public:
        Queue();
        T deQueue();
        bool enQueue(T data);
        bool isEmpty() const; 

    private:
        Node<T> *head;
        Node<T> *tail; 
};

template <typename T> 
Queue<T>::Queue()
{
    this->head = NULL;
    this->tail = NULL; 
}

template <typename T> 
bool Queue<T>::enQueue(T data)
{
    if(this->head == NULL || this->tail == NULL)
    {
        this->head = new Node<T>(data);
        this->tail = this->head; 
    } 
    else 
    {
        this->tail->setNext(new Node<T>(data)); 
        this->tail = this->tail->getNext();  
    }
    return true; 
}

template <typename T> 
T Queue<T>::deQueue()
{
    if(this->head == NULL)
    {
        throw underflow_error("Queue UnderFLow...."); 
    }
    else 
    {
        if(this->head == this->tail)
        {
            T element = this->head->getData();
            Node<T> *temp = this->head;
            this->head = NULL;
            this->tail = NULL;
            delete temp;
            return element;
        }
        else 
        {
            T element = this->head->getData();
            Node<T> *temp = this->head;
            this->head = this->head->getNext(); 
            delete temp;
            return element;
        }
    }
}

template <typename  T> 
bool Queue<T>::isEmpty() const
{
    return this->head == NULL; 
}

#endif 
