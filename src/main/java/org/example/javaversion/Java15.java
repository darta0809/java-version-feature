package org.example.javaversion;

import static java.security.spec.NamedParameterSpec.ED25519;

import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.NamedParameterSpec;
import java.util.Base64;

// must use sealed or non-sealed or final extends this
public final class Java15 extends Java15Abstract {

  public static void main(String[] args)
      throws NoSuchMethodException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {

    // new CharSequence isEmpty()
    Method method = CharSequence.class.getMethod("isEmpty");
    System.out.println(method);

    System.out.println("-------------------------------");

    // add EdDsa Ed25519 Signature Algorithm
    NamedParameterSpec ed25519 = ED25519;
    KeyPairGenerator kpg = KeyPairGenerator.getInstance("Ed25519");
    KeyPair kp = kpg.generateKeyPair();

    byte[] msg = "test_string".getBytes(StandardCharsets.UTF_8);

    Signature sig = Signature.getInstance("Ed25519");
    sig.initSign(kp.getPrivate());
    sig.update(msg);
    byte[] s = sig.sign();

    String encodedString = Base64.getEncoder().encodeToString(s);
    System.out.println(encodedString);

  }

  non-sealed class Java15Test extends Java15Abstract {
  }
}
