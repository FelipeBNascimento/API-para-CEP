package com.cepbazan.apicep;

import com.cepbazan.apicep.bussines.CepService;
import com.cepbazan.apicep.bussines.apiexterna.ConsumirApi;
import com.cepbazan.apicep.infraesctruture.repository.CepRepositorio;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@RequiredArgsConstructor
@ExtendWith(MockitoExtension.class)
public class CepServiceTest {

    @Mock
    private CepRepositorio cepRepositorio;

    @Mock
    private ConsumirApi consumirApi;

    @InjectMocks
    private final CepService cepService;


}
