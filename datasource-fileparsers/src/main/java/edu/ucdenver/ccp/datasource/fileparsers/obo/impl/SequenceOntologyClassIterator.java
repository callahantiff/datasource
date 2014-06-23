package edu.ucdenver.ccp.datasource.fileparsers.obo.impl;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.geneontology.oboedit.dataadapter.OBOParseException;

import edu.ucdenver.ccp.common.collections.CollectionsUtil;
import edu.ucdenver.ccp.common.download.HttpDownload;
import edu.ucdenver.ccp.common.file.CharacterEncoding;
import edu.ucdenver.ccp.datasource.fileparsers.obo.OboClassIterator;
import edu.ucdenver.ccp.datasource.fileparsers.obo.OboUtil;
import edu.ucdenver.ccp.datasource.fileparsers.obo.OboUtil.ObsoleteTermHandling;

/**
 * This class iterates over the gene ontology obo file and returns OBORecords for each class it
 * encounters.
 * 
 * @author bill
 * 
 */
public class SequenceOntologyClassIterator extends OboClassIterator {

	public static final String FILE_URL = "http://obo.cvs.sourceforge.net/*checkout*/obo/obo/ontology/genomic-proteomic/so.obo";
	public static final String ENCODING = "ASCII";

	@HttpDownload(url = FILE_URL)
	private File oboFile;

	public static final String ID_PREFIX = "SO:";

	public SequenceOntologyClassIterator(File oboOntologyFile, ObsoleteTermHandling obsoleteHandling)
			throws IOException, OBOParseException {
		super(oboOntologyFile, CharacterEncoding.UTF_8, obsoleteHandling);
	}

	public SequenceOntologyClassIterator(File workDirectory, boolean clean, ObsoleteTermHandling obsoleteHandling)
			throws IOException, OBOParseException {
		super(workDirectory, clean, obsoleteHandling);
	}

	@Override
	protected Set<String> getOntologyIdPrefixes() {
		return CollectionsUtil.createSet(ID_PREFIX);
	}

	@Override
	protected OboUtil<?> initializeOboUtilFromDownload() throws IOException, OBOParseException {
		return new OboUtil(oboFile, CharacterEncoding.UTF_8);
	}

}
