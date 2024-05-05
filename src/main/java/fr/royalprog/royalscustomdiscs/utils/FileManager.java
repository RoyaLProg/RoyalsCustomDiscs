package fr.royalprog.royalscustomdiscs.utils;

import com.mojang.logging.LogUtils;
import fr.royalprog.royalscustomdiscs.RoyaLsCustomDiscs;
import net.minecraft.client.Minecraft;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileManager {
	private	String path;
	private static final Logger LOGGER = LogUtils.getLogger();

	public FileManager(String path) {
		this.path = path;
	}
	public FileManager() {
		path = Minecraft.getInstance().gameDirectory.getAbsolutePath().replaceFirst("\\.", "musics/");
		createIfNotExist(path);
	}

	public void createIfNotExist(String spath) {
		try {
			Path path = Paths.get(spath);

			Files.createDirectories(path);
			LOGGER.info("directory " + spath + " created successfully");
		} catch ( Exception e){
			LOGGER.error("directory " + spath + " was not able to be created");
			LOGGER.error(e.getMessage());
		}
	}

	public Set<String> getFiles() {
		try {
			return Stream.of(new File(path).listFiles())
					.filter(file -> !file.isDirectory())
					.map(File::getName)
					.collect(Collectors.toSet());
		} catch (Exception e) {
			LOGGER.error("Could not get files in " + path);
			LOGGER.error(e.getMessage());

			return null;
		}
	}

	public void CopyFile (String original, String copy) throws IOException {
		Path copied = Paths.get(copy);
		Path originalPath = Paths.get(original);
		Files.copy(originalPath, copied, StandardCopyOption.REPLACE_EXISTING);
	}
}
