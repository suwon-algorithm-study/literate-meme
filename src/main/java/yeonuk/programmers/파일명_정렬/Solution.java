package yeonuk.programmers.파일명_정렬;

import java.util.Arrays;

public class Solution {

    public String[] solution(String[] files) {
        return Arrays.stream(files)
                .map(KakaoFile::new)
                .sorted()
                .map(KakaoFile::getFileName)
                .toArray(String[]::new);
    }

    static class KakaoFile implements Comparable<KakaoFile> {

        private String fileName;

        private String head;

        private String number;

        private String tail;

        public KakaoFile(String fileName) {
            this.fileName = fileName;

            int headIndex = 1;
            while (headIndex < fileName.length()) {
                if (fileName.charAt(headIndex) >= '0' && fileName.charAt(headIndex) <= '9') {
                    this.head = fileName.substring(0, headIndex);

                    int numberIndex = headIndex + 1;
                    while (numberIndex < fileName.length()  && fileName.charAt(numberIndex) >= '0' && fileName.charAt(numberIndex) <= '9') {
                        numberIndex++;
                    }
                    this.number = fileName.substring(headIndex, numberIndex);

                    this.tail = fileName.substring(numberIndex);

                    break;
                }

                headIndex++;
            }
        }

        public String getFileName() {
            return fileName;
        }

        @Override
        public int compareTo(KakaoFile o) {
            if (this.head.toLowerCase().compareTo(o.head.toLowerCase()) == 0) {
                return Integer.compare(Integer.parseInt(this.number) - Integer.parseInt(o.number), 0);
            } else {
                return this.head.toLowerCase().compareTo(o.head.toLowerCase());
            }
        }
    }
}
