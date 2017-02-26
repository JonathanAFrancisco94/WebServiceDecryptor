package com.webservicedecrypter.UI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.apache.commons.codec.binary.Base64;
/**
 * Webservice Decryptor
 * @author JFRAN
 * jfrancisc0@yahoo.com
 */
public class ViewDecrpyter {
	
	public static void main(String[] args) throws Exception {
		Display mainDisplay = new Display();
		Shell mainShell = new Shell(mainDisplay, SWT.MIN | SWT.CLOSE);
		mainShell.setImage(new Image(mainDisplay, "C:\\Users\\JFRAN\\workspace\\WebServiceDecryptor\\SC.ico"));
		
		// MAINSHELL PROPERTIES
		mainShell.setText("Webservice Encrpytor/Decryptor");
		mainShell.setSize(500, 250);
		mainShell.setLayout(new FormLayout());

		// label Decrypt
		Label lblDecrypt = new Label(mainShell, SWT.NONE);
		FormData labelDecrpyt = new FormData();
		labelDecrpyt.top = new FormAttachment(5, 0);
		labelDecrpyt.right = new FormAttachment(11, 0);
		lblDecrypt.setLayoutData(labelDecrpyt);
		lblDecrypt.setText("Decrypt");
		// text Decrypt
		final Text txtDecrypted = new Text(mainShell, SWT.BORDER | SWT.MULTI
				| SWT.WRAP | SWT.V_SCROLL);
		FormData decrypted = new FormData();
		decrypted.top = new FormAttachment(5, 2);
		decrypted.right = new FormAttachment(98, 0);
		decrypted.width = 400;
		decrypted.height = 70;
		txtDecrypted.setLayoutData(decrypted);

		// label Encrypt
		Label lblEncrypt = new Label(mainShell, SWT.NONE);
		FormData labelEncrpyt = new FormData();
		labelEncrpyt.top = new FormAttachment(43, 0);
		labelEncrpyt.right = new FormAttachment(11, 0);
		lblEncrypt.setLayoutData(labelEncrpyt);
		lblEncrypt.setText("Encrypt");
		// TextBox Encrypt
		final Text txtEncrypted = new Text(mainShell, SWT.BORDER | SWT.MULTI
				| SWT.WRAP | SWT.V_SCROLL);
		FormData encrypted = new FormData();
		encrypted.top = new FormAttachment(43, 2);
		encrypted.right = new FormAttachment(98, 0);
		encrypted.width = 400;
		encrypted.height = 70;
		txtEncrypted.setLayoutData(encrypted);

		// label Encrypt
		Label lblQuestion = new Label(mainShell, SWT.NONE);
		FormData labelQuestion = new FormData();
		labelQuestion.top = new FormAttachment(93, 0);
		labelQuestion.right = new FormAttachment(99, 0);
		FontData[] fd = lblQuestion.getFont().getFontData();
		fd[0].setHeight(8);
		lblQuestion.setFont(new Font(mainDisplay,fd[0]));
		lblQuestion.setLayoutData(labelQuestion);
		lblQuestion.setText("For Question: jfrancisc0@yahoo.com");
		
		// Encrypt Button
		Button btnEncrypt = new Button(mainShell, SWT.PUSH);
		btnEncrypt.setText("Encrypt");
		FormData encrypt = new FormData();
		encrypt.top = new FormAttachment(80, 2);
		encrypt.right = new FormAttachment(51, 17);
		encrypt.width = 210;
		btnEncrypt.setLayoutData(encrypt);
		btnEncrypt.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				// encode data on your side using BASE64
				byte[] bytesEncoded = Base64.encodeBase64(txtDecrypted.getText().getBytes());
				String encoded = new String(bytesEncoded);				
				txtEncrypted.setText(encoded);
			}

			// Select the Widget for my Button
			public void widgetDefaultSelected(SelectionEvent arg0) {
				System.out.println("widgetDefaultSelected");
			}
		});

		// Decrypt Button
		Button btnDecrypt = new Button(mainShell, SWT.PUSH);
		btnDecrypt.setText("Decrypt");
		FormData decrypt = new FormData();
		decrypt.top = new FormAttachment(80, 2);
		decrypt.right = new FormAttachment(96, 12);
		decrypt.width = 210;
		btnDecrypt.setLayoutData(decrypt);
		btnDecrypt.addSelectionListener(new SelectionListener() {
			public void widgetSelected(SelectionEvent arg0) {
				// Decode data on other side, by processing encoded data
				byte[] valueDecoded= Base64.decodeBase64(txtEncrypted.getText().trim().getBytes());
				String decoded = new String(valueDecoded);				
				txtDecrypted.setText(decoded);
			}

			// Select the Widget for my Button
			public void widgetDefaultSelected(SelectionEvent arg0) {
				System.out.println("widgetDefaultSelected");
			}
		});

		mainShell.open();
		while (!mainShell.isDisposed()) {
			if (!mainDisplay.readAndDispatch()) {
				mainDisplay.sleep();
			}
		}		
		mainShell.dispose();
	}
	
}
