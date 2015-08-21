package br.com.projetobase.web.rest;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import br.com.projetobase.modelo.Historico;

public class JsonStdHistoricoSerializer extends JsonSerializer<Historico> {

	@Override
	public void serialize(Historico historico, JsonGenerator json,
			SerializerProvider provider) throws IOException,
			JsonProcessingException {

		DateFormat myformat = new SimpleDateFormat("dd/MM/yyyy");
		json.writeStartObject();
		json.writeNumber(historico.getId());
		json.writeString(myformat.format(historico.getTempo()));
		
	}

}
