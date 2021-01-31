package ru.savinov.dictionary.docker.task_game;

 class Solution {
    public static void main(String[] args) {
        System.out.println(sendPassword("stalker72"));
    }

    public static int sendPassword(String password) {
        if (password.length() < 8) {
            return -1;
        }

        return Solution.hash8(password, Solution.table);
    }


    static int[] table = {47, 119, 181, 238, 85, 109, 230, 178, 73, 97, 70, 81, 49, 133, 137, 206, 175, 42, 254, 2, 228, 171, 251, 134, 227, 170, 211, 34, 111, 156, 132, 163, 241, 215, 83, 183, 54, 193, 236, 89, 8, 76, 39, 90, 141, 117, 239, 9, 233, 161, 41, 84, 13, 35, 167, 209, 45, 40, 139, 100, 99, 147, 197, 72, 158, 201, 207, 217, 95, 162, 152, 142, 160, 92, 225, 93, 246, 213, 61, 55, 203, 232, 11, 78, 199, 116, 6, 86, 60, 245, 36, 75, 38, 24, 10, 91, 186, 101, 32, 58, 250, 43, 221, 71, 88, 15, 53, 189, 118, 144, 185, 108, 77, 48, 56, 127, 121, 165, 150, 194, 196, 210, 240, 180, 31, 143, 65, 128, 59, 68, 3, 148, 12, 192, 168, 52, 67, 198, 222, 136, 80, 57, 243, 82, 33, 110, 205, 64, 174, 176, 115, 4, 216, 5, 154, 214, 69, 98, 145, 235, 112, 104, 130, 94, 26, 234, 223, 37, 173, 224, 149, 229, 204, 131, 96, 244, 159, 190, 129, 113, 255, 120, 21, 28, 202, 14, 30, 27, 157, 212, 218, 140, 220, 231, 237, 208, 124, 135, 87, 219, 17, 74, 50, 166, 179, 184, 23, 172, 226, 103, 191, 106, 114, 29, 200, 247, 242, 125, 249, 146, 195, 51, 126, 153, 19, 164, 188, 66, 169, 102, 1, 253, 182, 177, 122, 138, 62, 7, 25, 252, 155, 151, 63, 18, 44, 20, 105, 0, 107, 248, 16, 22, 79, 123, 187, 46};

    public static int hash8(String message, int[] table) {
        //Pearson hashing
        int hash = message.length() % 256;
        for (String i : message.split("")) {
            hash = table[hash ^ Character.codePointAt(i, 0)];
        }
        return hash;
    }

    public static int runCode(String password) {
       return sendPassword(password);
    }
}

