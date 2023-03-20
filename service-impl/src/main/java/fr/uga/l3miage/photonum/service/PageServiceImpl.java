package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.data.repo.PageRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Transactional
public class PageServiceImpl implements PageService {

    private final PageRepository pageRepository;

    @Autowired
    public PageServiceImpl(PageRepository pageRepository) {
        this.pageRepository = pageRepository;
    }


    @Override
    public Page save(Page page) {
        return pageRepository.save(page);
    }

    @Override
    public Page get(Long id) throws EntityNotFoundException {
        return pageRepository.get(id);
    }

    @Override
    public Collection<Page> list() {
        return pageRepository.all();
    }

    @Override
    public Page update(Page object) throws EntityNotFoundException {
        return pageRepository.save(object);
    }
}
