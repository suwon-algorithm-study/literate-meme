import java.util.Arrays;

class Solution {
  public String solution(String[] survey, int[] choices) {
    String answer = "";
    String[] types = { "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" };
    // RT: 0, FC: 1, MJ: 2, AN: 3(-: left, +: right)
    int[] scores = { 0, 0, 0, 0 };
    for (int i = 0; i < survey.length; i++) {
      if (survey[i].equals(types[0]))
        scores[0] += choices[i] - 4;
      else if (survey[i].equals(types[1]))
        scores[0] -= choices[i] - 4;
      else if (survey[i].equals(types[2]))
        scores[1] += choices[i] - 4;
      else if (survey[i].equals(types[3]))
        scores[1] -= choices[i] - 4;
      else if (survey[i].equals(types[4]))
        scores[2] += choices[i] - 4;
      else if (survey[i].equals(types[5]))
        scores[2] -= choices[i] - 4;
      else if (survey[i].equals(types[6]))
        scores[3] += choices[i] - 4;
      else if (survey[i].equals(types[7]))
        scores[3] -= choices[i] - 4;
    }

    if (scores[0] <= 0)
      answer += "R";
    else
      answer += "T";

    if (scores[1] < 0)
      answer += "F";
    else
      answer += "C";

    if (scores[2] < 0)
      answer += "M";
    else
      answer += "J";

    if (scores[3] <= 0)
      answer += "A";
    else
      answer += "N";

    return answer;
  }
}