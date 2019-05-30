import java.util.ArrayList;
import java.util.List;
import java.util.Observer;
import java.util.Observable;

public class appAfter {
    public static void main(String[] args) {
        NewsAgencyObservable observable = new NewsAgencyObservable();
        NewsChannelOberver observer = new NewsChannelOberver();

        //we add an instance of NewsChannel to the list of observers, 
        observable.addObserver(observer);
        observable.setNews("new information");
        observer.getNews();
        System.out.println(observer.getNews());
     }
}

class NewsAgencyObservable extends Observable {
    private String news;
    //private List<Channel> channels = new ArrayList<Channel>();

    // public void addObserver(Channel channel){
    //     channels.add(channel);
    // }

    // public void removeObserver(Channel channel) {
    //     channels.remove(channel);
    // }

    public void setNews(String news) {
        this.news = news;
        //Note that we don’t need to call the observer’s update() method directly. 
        //We just call stateChanged() and notifyObservers(), and the Observable class is doing the rest for us.
        setChanged();
        notifyObservers(news);
        // for(Channel ch: channels){
        //     ch.update(news);
        // }
        
    }
}


// interface Channel{
//     public void update(Object news);
// }

   
class NewsChannelOberver implements Observer {
    private String news;

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    @Override
    public void update(Observable o, Object news) {
        this.setNews((String) news);

    }
}

