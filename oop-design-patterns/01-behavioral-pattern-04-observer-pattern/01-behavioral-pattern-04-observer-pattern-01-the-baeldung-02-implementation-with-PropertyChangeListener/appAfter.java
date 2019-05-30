import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class appAfter {
    public static void main(String[] args) {
        NewsAgencyObservable observable = new NewsAgencyObservable();
        NewsChannelOberver observer = new NewsChannelOberver();

        //we add an instance of NewsChannel to the list of observers, 
        observable.addPropertyChangeListener(observer);
        observable.setNews("new information");
        observer.getNews();
        System.out.println(observer.getNews());
     }
}

class NewsAgencyObservable {
    private String news;
    private PropertyChangeSupport support;
    
    public NewsAgencyObservable(){
        support = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        support.addPropertyChangeListener(listener);
    }

    public void setNews(String news) {
        // the first argument is the name of the observed property. 
        // The second and the third arguments are its old and new value accordingly.
        support.firePropertyChange("news", this.news, news);
        this.news = news;
        
    }
}


class NewsChannelOberver implements PropertyChangeListener {
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

	@Override
	public void propertyChange(PropertyChangeEvent event) {
        this.setNews((String) event.getNewValue());
	}
}

