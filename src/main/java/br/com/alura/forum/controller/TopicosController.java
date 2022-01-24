package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.TopicoDTO;
import br.com.alura.forum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicosController {

    @Autowired
    TopicoRepository topicoRepository;

    @GetMapping
    public List<TopicoDTO> lista()
    {
        return TopicoDTO.converter(topicoRepository.findAll());
    }

    @GetMapping("/porNome/{nome}")
    public List<TopicoDTO> listaPorNome(@PathVariable("nome") String nome)
    {
        return TopicoDTO.converter(topicoRepository.findByTitulo(nome));
    }

    @GetMapping("/porCurso/{cursoNome}")
    public List<TopicoDTO> listaPorNomeCurso(@PathVariable("cursoNome") String cursoNome)
    {
        // podemos pegar o find com atributos do relacinamento passando a entidade primeiro
        // no caso curso e depois o atributo daquela entidade que queremos filtrar
        return TopicoDTO.converter(topicoRepository.findByCursoNome(cursoNome));
    }
}
