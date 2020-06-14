package ma.sopra.pocexchange.pocxchangeoffice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ResponseMessage {
    private String message;

	public ResponseMessage(String message) {
		super();
		this.message = message;
	}
   
}
