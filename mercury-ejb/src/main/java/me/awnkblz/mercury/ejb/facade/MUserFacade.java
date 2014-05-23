/*
 * Copyright 2013 Wirawan.Adi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.awnkblz.mercury.ejb.facade;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import me.awnkblz.mercury.domain.MUser;
import me.awnkblz.mercury.ejb.local.MUserFacadeLocal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Wirawan.Adi
 */
@Stateless
public class MUserFacade extends AbstractFacade<MUser> implements MUserFacadeLocal {

    private static final Logger LOGGER = LoggerFactory.getLogger(MUserFacade.class);
    @PersistenceContext(unitName = "mercury-PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MUserFacade() {
        super(MUser.class);
    }

    @Override
    public List<MUser> findACtiveUsers() {
        List<MUser> users = new ArrayList<>();

        try {
            Query query = em.createNamedQuery("Muser.findActiveUsers");
            users = query.getResultList();
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }

        return users;
    }
}
