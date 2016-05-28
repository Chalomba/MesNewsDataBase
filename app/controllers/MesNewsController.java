package controllers;

import models.MesNews;
import org.joda.time.DateTime;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.db.jpa.JPAApi;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by kirill on 5/21/16.
 */
public class MesNewsController extends Controller{

    private final FormFactory formFactory;

    private final JPAApi jpaApi;

    @Inject
    public MesNewsController(FormFactory formFactory, JPAApi jpaApi) {
        this.formFactory = formFactory;
        this.jpaApi = jpaApi;
    }

    /**
     * Reads a list of new from database and render it to the index page.
     *
     * @return
     */
    @Transactional
    public Result index() {
        List<MesNews> news = (List<MesNews>) jpaApi.em().createNativeQuery("SELECT * FROM MesNews", MesNews.class).getResultList();
        return ok(index.render(news));
    }


    /**
     * Create News from the data passed from the view and save it to the database.
     *
     * @return
     */
    @Transactional
    public Result addNews() {
        DynamicForm requestData = formFactory.form().bindFromRequest();
        MesNews news = new MesNews();
        news.source = requestData.get("source");
        news.author = requestData.get("author");
        news.title = requestData.get("title");
        news.date = DateTime.parse(requestData.get("date")).getMillis();
        jpaApi.em().persist(news);
        return redirect(routes.MesNewsController.index());
    }
}
