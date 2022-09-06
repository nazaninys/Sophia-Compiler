package main.symbolTable;


import main.symbolTable.exceptions.ItemAlreadyExistsException;
import main.symbolTable.exceptions.ItemNotFoundException;
import main.symbolTable.items.SymbolTableItem;
import main.symbolTable.utils.Stack;

import java.util.*;



public class SymbolTable {

    //Start of static members

    public static SymbolTable top;
    public static SymbolTable root;
    private static Stack<SymbolTable> stack = new Stack<>();

    public static void push(SymbolTable symbolTable) {
        if (top != null)
            stack.push(top);
        top = symbolTable;
    }

    public static void pop() {
        top = stack.pop();
    }

    //End of static members

    public SymbolTable pre;
    public ArrayList<SymbolTable> post = new ArrayList<>();
    private Map<String, SymbolTableItem> items;

    public SymbolTable() {
        this(null);
    }

    public SymbolTable(SymbolTable pre) {
        this.pre = pre;
        this.items = new HashMap<>();
    }

    public void put(SymbolTableItem item) throws ItemAlreadyExistsException {
        if (items.containsKey(item.getKey()))
            throw new ItemAlreadyExistsException();
        items.put(item.getKey(), item);
    }

    public SymbolTableItem getItem(String key, Boolean searchCurrent) throws ItemNotFoundException {
        Set<SymbolTable> visitedSymbolTables = new HashSet<>();
        SymbolTable currentSymbolTable = this;
        if(!searchCurrent) {
            visitedSymbolTables.add(this);
            currentSymbolTable = this.pre;
        }
        while((currentSymbolTable != null) && (!visitedSymbolTables.contains(currentSymbolTable))) {
            visitedSymbolTables.add( currentSymbolTable );
            SymbolTableItem symbolTableItem = currentSymbolTable.items.get(key);
            if( symbolTableItem != null )
                return symbolTableItem;
            currentSymbolTable = currentSymbolTable.pre;
        }
        throw new ItemNotFoundException();
    }

    public void hascon(String key, SymbolTable current, Set<SymbolTable> visited) throws ItemAlreadyExistsException{
        if(visited.contains(current))
            return;
        if (current.items.get(key) != null)
            throw new ItemAlreadyExistsException();
        visited.add(current);

        for(SymbolTable i:current.post){
            try{
                hascon(key,i,visited);
            } catch(ItemAlreadyExistsException e1){
                throw new ItemAlreadyExistsException();
            }
        }
    }

   public void getconflict(String key) throws ItemAlreadyExistsException{
       Set<SymbolTable> visited = new HashSet<>();
       try{
           hascon(key,this,visited);
       } catch(ItemAlreadyExistsException e2){
           throw new ItemAlreadyExistsException();
       }
   }





}
