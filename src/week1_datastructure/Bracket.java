// package week1_datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bracket {


    static class Bracket1 {

        char type;
        int position;

        Bracket1(char type, int position) {
            this.type = type;
            this.position = position;
        }

        boolean Match(char c) {
            if (this.type == '[' && c == ']')
                return true;
            if (this.type == '{' && c == '}')
                return true;
            if (this.type == '(' && c == ')')
                return true;
            return false;
        }

    }


    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        int error_pos = 0;
        Stack<Bracket1> opening_brackets_stack = new Stack<>();

        for (int position = 0; position < text.length(); position++) {
            char next = text.charAt(position);

            if (next == '(' || next == '[' || next == '{') {
                opening_brackets_stack.push(new Bracket1(next, position + 1));

            }

            if (next == ')' || next == ']' || next == '}') {
                // Process closing bracket, write your code here
                if (opening_brackets_stack.isEmpty()) {
                    error_pos = position + 1;
                    break;
                }
                Bracket1 pop = opening_brackets_stack.pop();
                if (!pop.Match(next)) {
                    error_pos = position + 1;
                    break;

                }

            }
        }

        if (error_pos == 0 && opening_brackets_stack.empty()) {

            System.out.println("Success");
        } else {
            System.out.println(error_pos);
            if (error_pos == 0) {
                while (opening_brackets_stack.size() > 1)
                    opening_brackets_stack.pop();
                error_pos = opening_brackets_stack.peek().position;
            }
            System.out.println(error_pos);
            // Printing answer, write your code here
        }
    }


}