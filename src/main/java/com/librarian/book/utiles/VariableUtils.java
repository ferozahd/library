package com.librarian.book.utiles;

import com.librarian.book.exception.InvalidConversion;
import org.bson.types.ObjectId;

public class VariableUtils {
    public static ObjectId strToObjId(String id){
        try {
            return new ObjectId(id);
        }catch (Exception exception){
            throw new InvalidConversion("Invalid Hex- ObjectId :"+id);
        }
    }
}
