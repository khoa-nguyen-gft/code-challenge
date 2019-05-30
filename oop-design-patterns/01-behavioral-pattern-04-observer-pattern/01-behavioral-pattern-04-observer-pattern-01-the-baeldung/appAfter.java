import java.util.ArrayList;
import java.util.List;

public class appAfter {
    public static void main(String[] args) {
        NewsAgencyObservable observable = new NewsAgencyObservable();
        NewsChannelOberver observer = new NewsChannelOberver();

        //we add an instance of NewsChannelOberver to the list of observers, 
        observable.addObserver(observer);
        observable.setNews("new information");
        observer.getNews();
        //change the state of NewsAgencyObservable, the instance of NewsChannelOberver will be updated:
        System.out.println(observer.getNews());
     }
}

class NewsAgencyObservable{
    private String news;
    private List<Channel> channels = new ArrayList<Channel>();

    public void addObserver(Channel channel){
        channels.add(channel);
    }

    public void removeObserver(Channel channel) {
        channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for(Channel ch: channels){
            ch.update(news);
        }
        
    }
}


interface Channel{
    public void update(Object news);
}


class NewsChannelOberver implements Channel {
    private String news;

    @Override
    public void update(Object news){
        this.setNews((String) news);
    }

    public String getNews() {
		return news;
	}

	public void setNews(String news) {
		this.news = news;
	}
}

