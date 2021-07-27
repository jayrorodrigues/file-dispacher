package br.jus.tjce.dispatcher.vo.v1;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({ "id", "arquivo"})
public class FileVO {
	
	@Mapping("id")
	@JsonProperty("id")
	private String hash;
	private byte file;
	private String extensao;
	
	@JsonIgnore
	private String ori;
	
	@JsonIgnore
	private String dest;
	
	/**
	 * @return the hash
	 */
	public String getHash() {
		return hash;
	}

	/**
	 * @param hash the hash to set
	 */
	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * @return the file
	 */
	public byte getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(byte file) {
		this.file = file;
	}

	/**
	 * @return the extensao
	 */
	public String getExtensao() {
		return extensao;
	}

	/**
	 * @param extensao the extensao to set
	 */
	public void setExtensao(String extensao) {
		this.extensao = extensao;
	}

	/**
	 * @return the ori
	 */
	public String getOri() {
		return ori;
	}

	/**
	 * @param ori the ori to set
	 */
	public void setOri(String ori) {
		this.ori = ori;
	}

	/**
	 * @return the dest
	 */
	public String getDest() {
		return dest;
	}

	/**
	 * @param dest the dest to set
	 */
	public void setDest(String dest) {
		this.dest = dest;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dest == null) ? 0 : dest.hashCode());
		result = prime * result + ((extensao == null) ? 0 : extensao.hashCode());
		result = prime * result + file;
		result = prime * result + ((hash == null) ? 0 : hash.hashCode());
		result = prime * result + ((ori == null) ? 0 : ori.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FileVO other = (FileVO) obj;
		if (dest == null) {
			if (other.dest != null)
				return false;
		} else if (!dest.equals(other.dest))
			return false;
		if (extensao == null) {
			if (other.extensao != null)
				return false;
		} else if (!extensao.equals(other.extensao))
			return false;
		if (file != other.file)
			return false;
		if (hash == null) {
			if (other.hash != null)
				return false;
		} else if (!hash.equals(other.hash))
			return false;
		if (ori == null) {
			if (other.ori != null)
				return false;
		} else if (!ori.equals(other.ori))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FileVO [hash=" + hash + ", file=" + file + ", extensao=" + extensao + ", ori=" + ori + ", dest=" + dest
				+ "]";
	}

}
