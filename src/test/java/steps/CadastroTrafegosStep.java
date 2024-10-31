package steps;

import com.networknt.schema.ValidationMessage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import model.ErrorTrafegoModel;
import org.junit.Assert;
import services.CadastroTrafegosService;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CadastroTrafegosStep {

    CadastroTrafegosService cadastroTrafegosService = new CadastroTrafegosService();

    @Dado("que eu tenha os seguintes dados de trafego:")
    public void queEuTenhaOsSeguintesDadosDaEntrega(List<Map<String, String>> rows) {
        for (Map<String, String> columns : rows) {
            cadastroTrafegosService.setFieldsDelivery(columns.get("campo"), columns.get("valor"));
        }
    }

    @Quando("eu enviar a requisicao para o endpoint {string} de cadastro de trafegos")
    public void euEnviarARequisicaoParaOEndpointDeCadastroDeEntregas(String endPoint) {
        cadastroTrafegosService.createDelivery(endPoint);
    }

//    @Entao("o status code da resposta deve ser {int}")
//    public void oStatusDaRespostaDeveSer(int statusCode) {
//        Assert.assertEquals(statusCode, cadastroTrafegosService.response.statusCode());
//    }

    @E("o corpo de resposta de erro da api deve retornar a mensagem {string}")
    public void oCorpoDeRespostaDeErroDaApiDeveRetornarAMensagem(String message) {
        ErrorTrafegoModel errorTrafegoModel = cadastroTrafegosService.gson.fromJson(
                cadastroTrafegosService.response.jsonPath().prettify(), ErrorTrafegoModel.class);
        Assert.assertEquals(message, errorTrafegoModel.getMessage());
    }

    @Dado("que eu recupere o ID do trafego criado no contexto")
    public void queEuRecupereOIDDaEntregaCriadaNoContexto() {
        cadastroTrafegosService.retrieveIdDelivery();
    }

    @Quando("eu enviar a requisicao com o ID para o endpoint {string} de delecao de trafego")
    public void euEnviarARequisicaoComOIDParaOEndpointDeDelecaoDeEntrega(String endPoint) {
        cadastroTrafegosService.deleteDelivery(endPoint);
    }

    @E("que o arquivo de contrato esperado e o {string}")
    public void queOArquivoDeContratoEsperadoEO(String contract) throws IOException {
        cadastroTrafegosService.setContract(contract);
    }

    @Entao("a resposta da requisicao deve estar em conformidade com o contrato selecionado")
    public void aRespostaDaRequisicaoDeveEstarEmConformidadeComOContratoSelecionado() throws IOException {
        Set<ValidationMessage> validateResponse = cadastroTrafegosService.validateResponseAgainstSchema();
        Assert.assertTrue("O contrato está inválido. Erros encontrados: " + validateResponse, validateResponse.isEmpty());
    }
}
