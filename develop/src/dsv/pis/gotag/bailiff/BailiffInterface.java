// BailiffInterface.java
// Fredrik Kilander, DSV
// 18-nov-2004/FK Adapted for PIS course.
// 2000-12-13/FK Adapted from earlier version.

package dsv.pis.gotag.bailiff;
import java.util.List;
import java.util.UUID;
import dsv.pis.gotag.dexter.Dexter;

/**
 * This interface is for the Bailiff's clients. This is mobile code which
 * move into the Bailiff's JVM for execution.
 */
public interface BailiffInterface
  extends
    java.rmi.Remote
{
    /**
     * Returns an integer containing info about how many players there are
     * in the bailiff
      * @return Integer
     * @throws java.rmi.RemoteException
     */
  public int getNumberOfAgents()
      throws java.rmi.RemoteException,
          java.net.UnknownHostException,
          java.net.UnknownServiceException;

    /**
     * Returns if an agent is it in the bailiff
     * @return boolean
     * @throws java.rmi.RemoteException
     * @throws java.net.UnknownHostException
     * @throws java.net.UnknownServiceException
     */
    public boolean isIt(String id)
        throws java.rmi.RemoteException,
            java.net.UnknownHostException,
            java.net.UnknownServiceException;

    /**
     * Method used for the agent to check whether it's in this bailiff or not.
     * @param uuid The unique identifier
     * @return true if agent is in the bailiff, false otherwise (if in another bailiff
     * or not in any bailiff at all)
     */
    public boolean amIHere(String uuid)
        throws java.rmi.RemoteException,
            java.net.UnknownHostException,
            java.net.UnknownServiceException;

    /**
     * Method used by the agent to delete itself from the hashmap of
     * active agents in the bailiff
     * @param uuid The unique identifier
     * @throws java.rmi.RemoteException
     * @throws java.net.UnknownHostException
     * @throws java.net.UnknownServiceException
     */
    public void deleteAgent(String uuid)
            throws java.rmi.RemoteException,
            java.net.UnknownHostException,
            java.net.UnknownServiceException;

    /**
     * Method used by the agent to get all names(uuids) of agents in the bailiff
     * @return ArrayList with names (uuids)
     * @throws java.rmi.RemoteException
     * @throws java.net.UnknownHostException
     * @throws java.net.UnknownServiceException
     */
    public String [] getNames()
            throws java.rmi.RemoteException,
            java.net.UnknownHostException,
            java.net.UnknownServiceException;
  /**
   * Returns a string which confirms communication with the Bailiff
   * service instance.
   */
  public String ping ()
    throws
      java.rmi.RemoteException;

  /**
   * Returns a property of the Bailiff.
   * @param key The case-insensitive property key to retrieve.
   * @return The property string or null.
   */
  public String getProperty (String key)
    throws
      java.rmi.RemoteException;

  /**
   * The entry point for mobile code.
   * The client sends and object (itself perhaps), a string
   * naming the callback method and an array of arguments which must
   * map against the parameters of the callback method.
   *
   * @param obj The object (to execute).
   * @param cb The name of the method to call as the program of obj.
   * @param args The parameters for the callback method. Note that if
   * the method has a signature without arguments the value of args
   * should be an empty array. Setting args to null will not work.
   * @exception java.rmi.RemoteException Thrown if there is an RMI problem.
   * @exception java.lang.NoSuchMethodException Thrown if the proposed
   * callback is not found (which happen if the name is spelled wrong,
   * the number of arguments is wrong or are of the wrong type).
   * 
   */
  public void migrate (Object obj, String cb, Object [] args)
    throws
      java.rmi.RemoteException,
      java.lang.NoSuchMethodException;

}
