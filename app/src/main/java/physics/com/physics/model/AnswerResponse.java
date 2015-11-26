package physics.com.physics.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Bruno - PC on 31/10/2015.
 */
public class AnswerResponse implements Serializable {

    private List<Answer> ans;

    public List<Answer> getAnswers() {
        return ans;
    }

    public void setAnswers(List<Answer> answers) {
        this.ans = answers;
    }


}
