package physics.com.physics.task;

import android.os.AsyncTask;
import android.util.Log;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import physics.com.physics.helper.QuestionsHelper;
import physics.com.physics.helper.TaskHelper;
import physics.com.physics.model.Answer;
import physics.com.physics.model.AnswerResponse;

/**
 * Created by bruno on 19/10/15.
 */
public class AnswerTask extends AsyncTask<Void, Void, List<Answer>> {

    private TaskHelper taskHelper = null;
    private List<Answer> answers;
    private HashMap<Long,String> userAnswers;
    private QuestionsHelper qHelper = new QuestionsHelper();
    private HashMap<Long,String> mapServer = new HashMap<Long,String>();
    private HashMap<Long,String> finalAnswers = new HashMap<Long,String>();
    private int contentId;

    public AnswerTask(HashMap<Long,String> userAnswers, TaskHelper taskHelper, int contentId) {
        this.userAnswers = userAnswers;
        this.taskHelper = taskHelper;
        this.contentId = contentId;
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected List<Answer> doInBackground(Void... params) {
        try {
            final String uri = "http://ec2-52-23-232-114.compute-1.amazonaws.com:8080/physics-api/answers/" + contentId;
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            answers = restTemplate.getForObject(uri, AnswerResponse.class).getAnswers();
            return answers;
        } catch (Exception e) {
            Log.e("MainActivity", e.getMessage(), e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(List<Answer> ans) {
        Log.d(answers.toString(),"Servidor");
        List<String> answerAtribuite = new ArrayList<>();
        for(Answer answer : answers){
            answerAtribuite.add(answer.getAnswer());
        }
        Long j = 1L;
        for(String i : answerAtribuite) mapServer.put(j++ , i);
        Log.d(mapServer.toString(),"HashMap");
        finalAnswers = qHelper.compareAnswers(mapServer, userAnswers);
        taskHelper.processFinish(finalAnswers);

    }

}
