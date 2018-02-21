package net.ufrog.aries.sample.domain.repositories;

import net.ufrog.aries.sample.domain.models.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 样例仓库
 *
 * @author ultrafrog, ufrog.net@gmail.com
 * @version 0.1, 2018-02-21
 * @since 0.1
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, String> {
}
