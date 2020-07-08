/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAs;

/**
 *
 * @author PC
 */
public class LCDEnodo<E>{
    
    private E content;
    private LCDEnodo<E> next;
    private LCDEnodo<E> previus;
    
    public LCDEnodo(E content){
        this.content =content;
        this.next = this;
        this.previus = this;
    }

    /**
     * @return the content
     */
    public E getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(E content) {
        this.content = content;
    }

    /**
     * @return the next
     */
    public LCDEnodo<E> getNext() {
        return next;
    }

    /**
     * @param next the next to set
     */
    public void setNext(LCDEnodo<E> next) {
        this.next = next;
    }

    /**
     * @return the previus
     */
    public LCDEnodo<E> getPrevius() {
        return previus;
    }

    /**
     * @param previus the previus to set
     */
    public void setPrevius(LCDEnodo<E> previus) {
        this.previus = previus;
    }
    
    
}
