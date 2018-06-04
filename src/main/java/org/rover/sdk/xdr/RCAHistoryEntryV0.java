// Automatically generated by xdrgen 
// DO NOT EDIT or your changes may be overwritten

package org.rover.sdk.xdr;


import java.io.IOException;

// === xdr source ============================================================

//  struct RCAHistoryEntryV0
//  {
//      RCAQuorumSet quorumSets<>; // additional quorum sets used by ledgerMessages
//      LedgerRCAMessages ledgerMessages;
//  };

//  ===========================================================================
public class RCAHistoryEntryV0  {
  public RCAHistoryEntryV0 () {}
  private RCAQuorumSet[] quorumSets;
  public RCAQuorumSet[] getQuorumSets() {
    return this.quorumSets;
  }
  public void setQuorumSets(RCAQuorumSet[] value) {
    this.quorumSets = value;
  }
  private LedgerRCAMessages ledgerMessages;
  public LedgerRCAMessages getLedgerMessages() {
    return this.ledgerMessages;
  }
  public void setLedgerMessages(LedgerRCAMessages value) {
    this.ledgerMessages = value;
  }
  public static void encode(XdrDataOutputStream stream, RCAHistoryEntryV0 encodedSCPHistoryEntryV0) throws IOException{
    int quorumSetssize = encodedSCPHistoryEntryV0.getQuorumSets().length;
    stream.writeInt(quorumSetssize);
    for (int i = 0; i < quorumSetssize; i++) {
      RCAQuorumSet.encode(stream, encodedSCPHistoryEntryV0.quorumSets[i]);
    }
    LedgerRCAMessages.encode(stream, encodedSCPHistoryEntryV0.ledgerMessages);
  }
  public static RCAHistoryEntryV0 decode(XdrDataInputStream stream) throws IOException {
    RCAHistoryEntryV0 decodedSCPHistoryEntryV0 = new RCAHistoryEntryV0();
    int quorumSetssize = stream.readInt();
    decodedSCPHistoryEntryV0.quorumSets = new RCAQuorumSet[quorumSetssize];
    for (int i = 0; i < quorumSetssize; i++) {
      decodedSCPHistoryEntryV0.quorumSets[i] = RCAQuorumSet.decode(stream);
    }
    decodedSCPHistoryEntryV0.ledgerMessages = LedgerRCAMessages.decode(stream);
    return decodedSCPHistoryEntryV0;
  }
}