package com.javarush.test.level27.lesson15.big01.ad;


import com.javarush.test.level27.lesson15.big01.ConsoleHelper;

/**
 * Created by stas on 8/18/16.
 */
public class AdvertisementManager
{
   private final AdvertisementStorage storage = AdvertisementStorage.getInstance();
	private int timeSeconds;

	public AdvertisementManager(int timeSeconds)
	{
		this.timeSeconds = timeSeconds;
	}

	public void processVideos() 
	{
		List<Advertisement> adStorage = storage.list();
		List<Advertisement> storageforDisplay = new ArrayList<Advertisement>();
		int lastseconds = timeSeconds;

		Collections.sort(adStorage, new Comparator<Advertisement>() 
				{
			@Override
			public int compare(Advertisement o1, Advertisement o2) {
				
				return Long.compare(o1.getAmountPerOneDisplaying(), o2.getAmountPerOneDisplaying());
			}
				});


		for (Advertisement advertisement : adStorage) 
		{
			if (advertisement.getDuration()<=lastseconds)
			{
				storageforDisplay.add(advertisement);
				lastseconds -= advertisement.getDuration();
			}
		}

		if (storageforDisplay.isEmpty())
		{
			throw new NoVideoAvailableException();
		}

		Collections.sort(storageforDisplay, new Comparator<Advertisement>() 
				{
			@Override
			public int compare(Advertisement o1, Advertisement o2) 
			{
				int flag = Long.compare(o2.getAmountPerOneDisplaying(), o1.getAmountPerOneDisplaying());
				if (flag!=0)
					return flag;
				flag = Long.compare(o1.getAmountPerOneDisplaying()*1000/o1.getDuration(), o1.getAmountPerOneDisplaying()*1000/o2.getDuration());
				return flag;
			}
				});

		for (Advertisement advertisement : storageforDisplay) 
		{
			ConsoleHelper.writeMessage(String.format("%s is displaying... %d, %d", 
					advertisement.getName(),
					advertisement.getAmountPerOneDisplaying(),
					advertisement.getAmountPerOneDisplaying()*1000/advertisement.getDuration()
					));	
			        advertisement.revalidate();
		}
	}
}
