package edu.ucdenver.ccp.datasource.fileparsers.irefweb;

/*
 * #%L
 * Colorado Computational Pharmacology's datasource
 * 							project
 * %%
 * Copyright (C) 2012 - 2016 Regents of the University of Colorado
 * %%
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 * 
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * 3. Neither the name of the Regents of the University of Colorado nor the names of its contributors
 *    may be used to endorse or promote products derived from this software without
 *    specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 * #L%
 */

import java.io.File;
import java.io.IOException;
import java.util.Set;

import edu.ucdenver.ccp.common.download.HttpDownload;
import edu.ucdenver.ccp.common.file.CharacterEncoding;
import edu.ucdenver.ccp.common.file.reader.StreamLineReader;
import edu.ucdenver.ccp.datasource.identifiers.impl.bio.NcbiTaxonomyID;

public class IRefWebPsiMitab2_6FileParser_AllSpecies extends IRefWebPsiMitab2_6FileParser {

	@HttpDownload(url = "http://irefindex.org/download/irefindex/data/archive/release_14.0/psi_mitab/MITAB2.6/All.mitab.07042015.txt.zip", decompress = true, targetFileName = "All.mitab.04072015.txt")
	private File allMitabTxtFile;

	public IRefWebPsiMitab2_6FileParser_AllSpecies(File workDirectory, boolean clean) throws IOException {
		super(workDirectory, clean);
	}

	public IRefWebPsiMitab2_6FileParser_AllSpecies(File workDirectory, boolean clean, Set<NcbiTaxonomyID> taxonIds)
			throws IOException {
		super(workDirectory, clean, taxonIds);
	}

	public IRefWebPsiMitab2_6FileParser_AllSpecies(File file, CharacterEncoding encoding, Set<NcbiTaxonomyID> taxonIds)
			throws IOException, IllegalArgumentException {
		super(file, encoding, taxonIds);
	}

	public IRefWebPsiMitab2_6FileParser_AllSpecies(File file, CharacterEncoding encoding) throws IOException,
			IllegalArgumentException {
		super(file, encoding);
	}

	@Override
	protected StreamLineReader initializeLineReaderFromDownload(CharacterEncoding encoding, String skipLinePrefix)
			throws IOException {
		return new StreamLineReader(allMitabTxtFile, encoding, skipLinePrefix);
	}

}
