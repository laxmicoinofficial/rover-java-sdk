package org.rover.sdk;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Represents an account in Rover network with it's sequence number.
 * Account object is required to build a {@link Transaction}.
 * @see org.rover.sdk.Transaction.Builder
 */
public class Account implements TransactionBuilderAccount {
  private final KeyPair mKeyPair;
  private Long mSequenceNumber;

  /**
   * Class constructor.
   * @param keypair KeyPair associated with this Account
   * @param sequenceNumber Current sequence number of the account (can be obtained using rover-java-sdk or orbit server)
   */
  public Account(KeyPair keypair, Long sequenceNumber) {
    mKeyPair = checkNotNull(keypair, "keypair cannot be null");
    mSequenceNumber = checkNotNull(sequenceNumber, "sequenceNumber cannot be null");
  }

  @Override
  public KeyPair getKeypair() {
    return mKeyPair;
  }

  @Override
  public Long getSequenceNumber() {
    return mSequenceNumber;
  }

  @Override
  public Long getIncrementedSequenceNumber() {
    return new Long(mSequenceNumber + 1);
  }

  /**
   * Increments sequence number in this object by one.
   */
  public void incrementSequenceNumber() {
    mSequenceNumber++;
  }
}
