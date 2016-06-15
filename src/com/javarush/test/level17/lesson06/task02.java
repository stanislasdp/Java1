package level17.lesson06;

/* �����������
�� ��������� synchronized �������� ���, ����� ���������� ��������� � �������� ����������� ���� ����������.
*/
public class task02 
{

	   public static volatile int proposal = 0;

	    public static void main(String[] args) {
	        new MakeProposal().start();
	        new AcceptProposal().start();
	    }

	    public static class MakeProposal extends Thread {
	        @Override
	        
	        public void run() 
	        {
	            int thisProposal = proposal;

	            while (proposal < 10) 
	            {
	                System.out.println("������� ����������� �" + (thisProposal + 1));
	                proposal = ++thisProposal;
	                try {
	                    Thread.sleep(100);
	                } catch (InterruptedException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    }

	    public static class AcceptProposal extends Thread {
	        @Override
	        public void run() {
	            int thisProposal = proposal;

	            while (thisProposal < 10) {
	                if (thisProposal != proposal) {
	                    System.out.println("������� ����������� �" + proposal);
	                    thisProposal = proposal;
	                }
	            }
	        }
	    }
}
