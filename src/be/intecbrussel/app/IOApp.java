package be.intecbrussel.app;

import java.io.File;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;

import be.intecbrussel.entities.ObjectFile;
import be.intecbrussel.utilities.FileTools;

public class IOApp {
	  
	public static void main(String[] args) {
		
		 try {
	            // 1) Creation of the sorted directory
			 FileTools.checkIfSortedDirExistElseCreate();
			 //FileTools is een klasse  die er wordt aangemaakt, door aanroepen van de methode die in de klasse
			 //FileTools wordt bestaan
			 
			 
			 
	         
	      	

	            // 2) Creation of the unsorted path

	            Path unsortedPath = FileTools.checkIfUnsortedExistPathElseCreate();
	            //ook er wordt een unsorted path aangemaakt die  de methode in KLasse FileTools wordt geplaatst
	            



	            /**

	            3)  Creation of a List  with all the files and directories placed

	                under the "unsorted" directory.

	            */

	            List<File> allPaths = FileTools.fillFileAndDir(new File(unsortedPath.toString()));
	          //  om een lijst met alle bestanden en directories aan te maken met unsorted directory





	            // 4) The List "document" contains only the files under the "unsorted" directory.

	            List<File> documents = FileTools.keepOnlyDocuments(allPaths);
 // deze list wordt gebruikt om alleen de files van unsorted pad te krijgen


	             /**

	             5) Creation of a List with all the ObjectFile's. An ObjectFile

	                contains all the useful properties of a particular file

	             */

	            List<ObjectFile> listFileAttributes = FileTools.createListFileAttributes(documents);
	            





	            // 6) Creation of the "extension file" directories

	            FileTools.createExtensionFileDirectory(listFileAttributes);





	            // 7) Copy of the files in the sorted directory

	            for (ObjectFile of : listFileAttributes) {



	                FileTools.checkIfFileExistElseCopy(of.getSourcePath(), of.getCompletePath());

	            }



	            // 8) Creation of the summary directory

	            FileTools.checkIfsummaryDirExistElseCreate();



	            /**

	            9) Before the creation of the summary file, the List listFileAttributes

	                is sorted by the extension of the files

	            */

	            listFileAttributes.sort(Comparator.comparing(a -> a.getExtension()));



	            // 10) Creation and creation of the file summary.txt

	            FileTools.summaryFileCreation();



	            // 11) Number of files sorted

	            System.out.println(listFileAttributes.size() + " files have been placed in the sorted directory.");



	        } catch (Exception e) {

	            System.out.println("Whoops: " + e.getMessage());

	        }
	}
}
