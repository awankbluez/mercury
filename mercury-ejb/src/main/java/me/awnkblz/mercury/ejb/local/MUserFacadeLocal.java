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
package me.awnkblz.mercury.ejb.local;

import java.util.List;
import javax.ejb.Local;
import me.awnkblz.mercury.domain.MUser;

/**
 *
 * @author Wirawan.Adi
 */
@Local
public interface MUserFacadeLocal {

    void create(MUser mUser);

    void edit(MUser mUser);

    void remove(MUser mUser);

    MUser find(Object id);

    List<MUser> findAll();

    List<MUser> findACtiveUsers();

    List<MUser> findRange(int[] range);

    int count();
}
