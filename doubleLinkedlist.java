package P2J2;

import java.util.Scanner;

public class Double_Linked_List {
    Node awal;
    Node akhir;

    public Double_Linked_List(){
        awal=null;
        akhir=null;
    }

    public boolean periksa_isEmpty(){
        return(awal==null);
    }

    public void insert_dari_Awal(int data){
        Node node = new Node(data);
        if (periksa_isEmpty()){
            akhir=node;
        }
        else {
            awal.prev=node;
        }
        node.next=awal;
        awal=node;
    }

    public void insert_dari_akhir(int data){
        Node node = new Node (data);

        if(periksa_isEmpty()){
            awal=node;
        }
        else{
            akhir.next=node;
            node.prev=akhir;
        }
        akhir=node;
    }

    public Node hapus_data_awal(){
        Node temp= awal;
        if(awal.next==null)
            akhir=null;
        else
            awal.next.prev=null;
        awal=awal.next;
        return temp;
    }

    public Node hapus_data_akhir(){
        Node temp=akhir;
        if(awal.next==null)
            awal=null;
        else
            akhir.prev.next=null;
        akhir=akhir.prev;
        return temp;
    }

    public boolean insert_data_tengah (int key, int data){
        Node current=awal;
        while (current.data != key){
            current = current.next;
            if(current==null)
                return false;
        }
        Node node = new Node(data);

        if(current==akhir){
            node.next=null;
            akhir=node;
        }
        else{
            node.next=current.next;
            current.next.prev=node;
        }
        node.prev= current;
        current.next=node;
        return true;
    }

    public Node hapus_key(int key){
        Node current = awal;
        while (current.data !=key){
            current=current.next;
            if(current==null)
                return null;
        }
        if (current==awal)
            awal=current.next;
        else
            current.prev.next=current.next;
        if (current==akhir)
            akhir=current.next.prev;
        else
            current.next.prev=current.prev;
            return current;
    }

    public void tampil_awal_akhir(){
        System.out.println("Data(awal--->akhir) : ");
        Node current=awal;
        while (current != null){
            current.tampil();
            current=current.next;
        }
        System.out.println("");
    }

    public void tampil_akhir_awal(){
        System.out.println("Data (akhir--->awal): ");
        Node current=akhir;
        while (current !=null){
            current.tampil();
            current=current.prev;
        }
        System.out.println("");
    }

    public static void main (String[] args){
        Double_Linked_List list = new Double_Linked_List();
        int jumlah;

        System.out.println("masukan panjang linkedlist ");
        jumlah=new Scanner(System.in).nextInt();

        for (int i = 1; i<=jumlah; i++){
            list.insert_dari_Awal(new Scanner(System.in).nextInt());
        }

        list.tampil_akhir_awal();

        for (int i = 1; i<=jumlah; i++){
            list.insert_dari_akhir(new Scanner(System.in).nextInt());
        }

        list.tampil_awal_akhir();

        list.hapus_key(33);
        list.tampil_awal_akhir();

        list.insert_data_tengah(22,88);
        list.insert_data_tengah(25, 77);
        list.tampil_akhir_awal();

    }

