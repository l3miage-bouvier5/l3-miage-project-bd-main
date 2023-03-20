package fr.uga.l3miage.photonum.service;

import fr.uga.l3miage.photonum.data.domain.Page;
import fr.uga.l3miage.photonum.service.base.BaseService;

import java.util.Collection;

public interface PageService extends BaseService<Page, Long> {

    Page save(Page page);


}