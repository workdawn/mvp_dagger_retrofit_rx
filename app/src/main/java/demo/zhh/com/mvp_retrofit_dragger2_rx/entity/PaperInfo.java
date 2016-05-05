package demo.zhh.com.mvp_retrofit_dragger2_rx.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * 壁纸实体
 */
public class PaperInfo extends BaseData {

	private Link link;
	//private List<Time> useTime;
	private List<Slider> slider;
	private ArrayList<Data> data;

	public Link getLink() {
		return link;
	}

	public void setLink(Link link) {
		this.link = link;
	}

	/*public List<Time> getUseTime() {
		return useTime;
	}

	public void setUseTime(List<Time> useTime) {
		this.useTime = useTime;
	}*/

	public List<Slider> getSlider() {
		return slider;
	}

	public void setSlider(List<Slider> slider) {
		this.slider = slider;
	}

	public ArrayList<Data> getData() {
		return data;
	}

	public void setData(ArrayList<Data> data) {
		this.data = data;
	}

	/*public static class Time {
	}*/

	public static class Slider {
		private String type;

		private String name;

		private String detail;

		private String analyze;

		private String image;

		public void setType(String type){
		this.type = type;
		}
		public String getType(){
		return this.type;
		}
		public void setName(String name){
		this.name = name;
		}
		public String getName(){
		return this.name;
		}
		public void setDetail(String detail){
		this.detail = detail;
		}
		public String getDetail(){
		return this.detail;
		}
		public void setAnalyze(String analyze){
		this.analyze = analyze;
		}
		public String getAnalyze(){
		return this.analyze;
		}
		public void setImage(String image){
		this.image = image;
		}
		public String getImage(){
		return this.image;
		}
	}

	public static class Link {
		private String prev;

		private String self;

		private String next;

		public void setPrev(String prev){
		this.prev = prev;
		}
		public String getPrev(){
		return this.prev;
		}
		public void setSelf(String self){
		this.self = self;
		}
		public String getSelf(){
		return this.self;
		}
		public void setNext(String next){
		this.next = next;
		}
		public String getNext(){
		return this.next;
		}
	}

	public static class Data {
		private boolean enterable;
		private long file_id;
		private int size_id;
		private long group_id;
		private String key;
		private String number;
		private String dlview;
		private String detail;
		private boolean allow_diy;
		private Image image;
		private Counts counts;
		private Share share;
		private User user;
		private List<Tags> tags;

		public Image getImage() {
			return image;
		}

		public void setImage(Image image) {
			this.image = image;
		}

		public Counts getCounts() {
			return counts;
		}

		public void setCounts(Counts counts) {
			this.counts = counts;
		}

		public Share getShare() {
			return share;
		}

		public void setShare(Share share) {
			this.share = share;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
		}

		public List<Tags> getTags() {
			return tags;
		}

		public void setTags(List<Tags> tags) {
			this.tags = tags;
		}

		public boolean isEnterable() {
			return enterable;
		}

		public void setEnterable(boolean enterable) {
			this.enterable = enterable;
		}

		public long getFile_id() {
			return file_id;
		}

		public void setFile_id(long file_id) {
			this.file_id = file_id;
		}

		public int getSize_id() {
			return size_id;
		}

		public void setSize_id(int size_id) {
			this.size_id = size_id;
		}

		public long getGroup_id() {
			return group_id;
		}

		public void setGroup_id(long group_id) {
			this.group_id = group_id;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getNumber() {
			return number;
		}

		public void setNumber(String number) {
			this.number = number;
		}

		public String getDlview() {
			return dlview;
		}

		public void setDlview(String dlview) {
			this.dlview = dlview;
		}

		public String getDetail() {
			return detail;
		}

		public void setDetail(String detail) {
			this.detail = detail;
		}

		public boolean isAllow_diy() {
			return allow_diy;
		}

		public void setAllow_diy(boolean allow_diy) {
			this.allow_diy = allow_diy;
		}

		public static class Image {
			private String small;
			private String big;
			private String original;
			private String vip_original;
			private String diy;

			public String getSmall() {
				return small;
			}

			public void setSmall(String small) {
				this.small = small;
			}

			public String getBig() {
				return big;
			}

			public void setBig(String big) {
				this.big = big;
			}

			public String getOriginal() {
				return original;
			}

			public void setOriginal(String original) {
				this.original = original;
			}

			public String getVip_original() {
				return vip_original;
			}

			public void setVip_original(String vip_original) {
				this.vip_original = vip_original;
			}

			public String getDiy() {
				return diy;
			}

			public void setDiy(String diy) {
				this.diy = diy;
			}

		}

		public static class Counts {
			private String loved;
			private String share;
			private String down;
			private String puzzle;

			public String getLoved() {
				return loved;
			}

			public void setLoved(String loved) {
				this.loved = loved;
			}

			public String getShare() {
				return share;
			}

			public void setShare(String share) {
				this.share = share;
			}

			public String getDown() {
				return down;
			}

			public void setDown(String down) {
				this.down = down;
			}

			public String getPuzzle() {
				return puzzle;
			}

			public void setPuzzle(String puzzle) {
				this.puzzle = puzzle;
			}

		}

		public static class Share {
			private String api;
			private String url;
			private String pic;

			public String getApi() {
				return api;
			}

			public void setApi(String api) {
				this.api = api;
			}

			public String getUrl() {
				return url;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getPic() {
				return pic;
			}

			public void setPic(String pic) {
				this.pic = pic;
			}

		}

		public static class User {
			private Love love;

			private String addtag;

			public void setLove(Love love) {
				this.love = love;
			}

			public Love getLove() {
				return this.love;
			}

			public void setAddtag(String addtag) {
				this.addtag = addtag;
			}

			public String getAddtag() {
				return this.addtag;
			}

			public static class Love {
				private boolean status;

				private String create;

				private String remove;

				public void setStatus(boolean status) {
					this.status = status;
				}

				public boolean getStatus() {
					return this.status;
				}

				public void setCreate(String create) {
					this.create = create;
				}

				public String getCreate() {
					return this.create;
				}

				public void setRemove(String remove) {
					this.remove = remove;
				}

				public String getRemove() {
					return this.remove;
				}

			}

		}

		public static class Tags {
			private int tid;

			private String name;

			private String url;

			public void setTid(int tid) {
				this.tid = tid;
			}

			public int getTid() {
				return this.tid;
			}

			public void setName(String name) {
				this.name = name;
			}

			public String getName() {
				return this.name;
			}

			public void setUrl(String url) {
				this.url = url;
			}

			public String getUrl() {
				return this.url;
			}

		}
	}
}
