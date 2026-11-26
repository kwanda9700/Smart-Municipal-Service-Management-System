package za.co.municipality.smartservice.filehandling;

import za.co.municipality.smartservice.model.ServiceRequest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/** Exports a snapshot of service requests to a UTF-8 CSV file. */
public class RequestFileExporter {

    public void export(List<ServiceRequest> requests, Path file) throws IOException {
        List<String> lines = new ArrayList<>();
        lines.add("id,citizen,type,status");

        for (ServiceRequest request : requests) {
            lines.add(csv(request.getRequestId()) + ","
                    + csv(request.getCitizenName()) + ","
                    + csv(request.getRequestType()) + ","
                    + csv(request.getStatus()));
        }

        Path parent = file.toAbsolutePath().getParent();
        if (parent != null) {
            Files.createDirectories(parent);
        }
        Files.write(file, lines, StandardCharsets.UTF_8);
    }

    private String csv(Object value) {
        if (value == null) {
            return "";
        }
        String text = value.toString();
        if (text.contains(",") || text.contains("\"") || text.contains("\n") || text.contains("\r")) {
            return "\"" + text.replace("\"", "\"\"") + "\"";
        }
        return text;
    }
}
